import com.sun.source.tree.TryTree;

import java.sql.*;
import java.util.Random;

public class Quotes {
    private static final String URL = "jdbc:sqlite:quotes.db";
    protected int sentenceID;
    protected String sentence;

    protected Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        }catch (Exception e){
            System.out.println("Error in connecting to the database");
        }
        return conn;
    }

    public Quotes(){
        Random rand = new Random();
        sentenceID = rand.nextInt(49)+1;
        String sql = "SELECT sentence FROM quotes WHERE id = " + sentenceID;

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            sentence = rs.getString("sentence");
            System.out.println(sentence);
        } catch (SQLException e) {
            System.out.println("hata 1 : "+ e.getMessage());
        }

    }
}
