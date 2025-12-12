import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Objects;

public class CreateDbQuote {
    // Sadece Klasör Adını Düzeltin, Eğik Çizgiyi Kaldırın
    private static final String txtPath = Objects.requireNonNull(CreateDbQuote.class.getClassLoader().getResource("resources/DailyQuotes.txt")).getPath();
    private static final String URL = "jdbc:sqlite:quotes.db";

    private static Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        }catch (Exception e){
            System.out.println("Connection Failed! Check output console" + e.getMessage());
        }
        return  conn;
    }

    private static void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS quotes(\n"
                +"id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                +"sentence TEXT NOT NULL\n"
                +");";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();){
            stmt.execute(sql);
            System.out.println("Table Created!");
        }catch (Exception e){
            System.out.println("Table Creation Failed!" + e.getMessage());
        }
    }

    private static void addSentence(String sentence){

        String sql = "INSERT OR IGNORE INTO quotes (sentence) VALUES (?)";


        try (Connection conn = connect(); PreparedStatement preStat = conn.prepareStatement(sql)){
            preStat.setString(1, sentence);
            preStat.executeUpdate();
            System.out.println("sentence added");

        }catch (SQLException e){
            System.err.println(" 1Hata :"+e.getMessage());
        }
    }
    private static void PrintAllWords(){
        String sql = "SELECT id, sentence FROM quotes ORDER BY id ASC";
        try (Connection conn = connect();
             Statement stat = conn.createStatement();
             ResultSet resultSet =stat.executeQuery(sql)){
            if (isEmptyDB())
                System.out.println("Empty DB");
            System.out.println("----- All sentences found -----");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String sentence = resultSet.getString("sentence");
                System.out.println(id+"--->"+sentence);
            }
            System.out.println("------------------\n");

        }catch (Exception e) {
            System.err.println(" 2 Hata :" + e.getMessage());
        }
    }
    private static void txtToDb(){
        int sentenceCounter = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(txtPath))){
            String line;
            System.out.println("Reading file");

            // Başlık satırını atlamak için ilk satırı oku
            br.readLine();

            while ((line = br.readLine()) != null) {
                String cleanedLine = line.trim();
                if (cleanedLine.isEmpty())
                    continue;

                // Sondaki "-" işaretini kaldır (Gerekirse)
                if (cleanedLine.endsWith("-")) {
                    cleanedLine = cleanedLine.substring(0, cleanedLine.length() - 1);
                }

                addSentence(cleanedLine); // Temizlenmiş satırı ekle
                sentenceCounter++;
            }
            System.out.println("Word Counter: " + sentenceCounter);

        }catch (Exception e){
            System.err.println("3Hata : "+e.getMessage());
        }
    }

    private static boolean isEmptyDB(){
        String sql = "SELECT id FROM quotes LIMIT 1";

        try(Connection conn = connect();
            Statement stat = conn.createStatement();
            ResultSet resultSet =stat.executeQuery(sql);){
            if (!resultSet.next()){
                System.out.println("No words found");
                return true;
            }
            return false;

        }catch (Exception e){
            System.err.println("4Hata : "+e.getMessage());
        }
        return false;

    }
    public static void generateDB(){
        createTable();
        if(isEmptyDB()){
            System.out.println("db is created");
            txtToDb();
            PrintAllWords();
        }else{
            System.out.println("db already exists");
            PrintAllWords();
        }
    }

}
