import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class CreateDB {
    private static final String URL = "jdbc:sqlite:dictionary.db";

    private static Connection connect(){
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(URL);
        } catch (SQLException | ClassNotFoundException e ) {
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
        String sql = "SELECT id,word,meaning,is_teached,wrong_counter FROM words ORDER BY id ASC";
        try (Connection conn = connect();
             Statement stat = conn.createStatement();
             ResultSet resultSet =stat.executeQuery(sql)){
            if (!resultSet.next()){
                System.out.println("No words found");
                return;
            }
            System.out.println("----- All words-----");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String word = resultSet.getString("word");
                String meaning = resultSet.getString("meaning");
                int  is_teached = resultSet.getInt("is_teached");
                int  wrong_counter = resultSet.getInt("wrong_counter");
                System.out.println(id+"--->"+word+"--->"+meaning+"--->"+is_teached+"--->"+wrong_counter);
            }
            System.out.println("------------------\n");

        }catch (Exception e) {
            System.err.println("Hata :" + e.getMessage());
        }
    }

    private static void txtToDb(){
        int wordCounter = 0;
        InputStream is = CreateDB.class.getResourceAsStream("/words.txt");
        if (is == null){
            System.err.println("ERROR : words.txt not found");
        }

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(is,StandardCharsets.UTF_8))){
            String line;
            while((line = reader.readLine()) != null){
                String[] words = line.trim().split("\\s+");
                if (words.length >= 2){
                    addWord(words[0], words[1]);
                }
            }
        }catch (Exception e){
            System.err.println("Hata :" + e.getMessage());
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
            PrintAllWords();
        }

    }


}
