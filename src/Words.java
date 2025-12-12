import java.sql.*;

public class Words {

    private static final String URL = "jdbc:sqlite:dictionary.db";
    protected int wordId;
    protected String word,meaning;
    protected int isTeached,wrongCounter;

    protected Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public Words(){}
    protected void GenerateWord(int WordId){
        this.wordId = WordId;
        String query = "SELECT * FROM words WHERE id = ?";
        try(Connection conn = connect();
            PreparedStatement preStm = conn.prepareStatement(query);){
            preStm.setInt(1, wordId);
            ResultSet resultSet = preStm.executeQuery();
            while (resultSet.next()){
                word = resultSet.getString("word");
                meaning = resultSet.getString("meaning");
                isTeached = resultSet.getInt("is_teached");
                wrongCounter = resultSet.getInt("wrong_counter");
            }

        }catch (Exception e ){
            System.out.println("Error : "+ e.getMessage());
        }
    }

    public void setWrongCounter(boolean b) {
    }

    public void setIsTeached(boolean b) {
    }
}
