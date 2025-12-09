import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class CreateDB {
    private static final String txtPath = CreateDB.class.getResource("/resources/words.txt").getPath();

    private static final String URL = "jdbc:sqlite:dictionary.db";

    private static Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println("Hata :"+e.getMessage());
        }
        return conn;
    };

    private static void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS words (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " word TEXT NOT NULL UNIQUE,\n"
                + " meaning TEXT NOT NULL,\n"
                + " is_teached INTEGER DEFAULT 0,\n"
                + " wrong_counter INTEGER DEFAULT 0\n"
                + ");";

        try(Connection conn = connect();
            Statement stat = conn.createStatement()){
            stat.execute(sql);
            System.out.println("Table Created");

        } catch (SQLException e) {
            System.err.println("Hata :"+e.getMessage());
        }
    }

    private static void addWord(String word, String meaning){

        String sql = "INSERT OR IGNORE INTO words (word,meaning) VALUES (? , ?)";

        try (Connection conn = connect(); PreparedStatement preStat = conn.prepareStatement(sql)){
            preStat.setString(1, word);
            preStat.setString(2, meaning);
            preStat.executeUpdate();
            System.out.println("Word added");
        }catch (SQLException e){
            System.err.println("Hata :"+e.getMessage());
        }
    }

    private static void PrintAllWords(){
        String sql = "SELECT word,meaning FROM words ORDER BY id ASC";
        try (Connection conn = connect();
             Statement stat = conn.createStatement();
             ResultSet resultSet =stat.executeQuery(sql)){
            if (!resultSet.next()){
                System.out.println("No words found");
                return;
            }
            System.out.println("----- All words-----");
            while (resultSet.next()){
                String word = resultSet.getString("word");
                String meaning = resultSet.getString("meaning");
                System.out.println(word+"--->"+meaning);
            }
            System.out.println("------------------\n");

        }catch (Exception e) {
            System.err.println("Hata :" + e.getMessage());
        }
    }

    private static void txtToDb(){
        int wordCounter = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(txtPath))){
            String line;
            System.out.println("Reading file");
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || !line.contains(" "))
                    continue;

                String[] parts = line.split(" ",2);
                if (parts.length == 2){
                    String word = parts[0].trim();
                    String meaning = parts[1].trim();
                    addWord(word,meaning);
                    wordCounter++;
                }
            }
            System.out.println("Word Counter: " + wordCounter);

        }catch (Exception e){
            System.err.println("Hata : "+e.getMessage());
        }
    }

    private static boolean isEmptyDB(){
        String sql = "SELECT id FROM words LIMIT 1";

        try(Connection conn = connect();
        Statement stat = conn.createStatement();
        ResultSet resultSet =stat.executeQuery(sql);){
            if (!resultSet.next()){
                System.out.println("No words found");
                return true;
            }
            return false;

        }catch (Exception e){
            System.err.println("Hata : "+e.getMessage());
        }
        System.err.println("hata");
        return false;

    }

    public static void generateDB(){
        createTable();
        if (isEmptyDB()){
            System.out.println("Database Created");
            txtToDb();
            PrintAllWords();
        }
        else {
            System.out.println("Database already exists");
        }

    }


}
