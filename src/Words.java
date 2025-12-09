import java.sql.*;

public class Words {

    private static final String URL = "jdbc:sqlite:dictionary.db";
    protected int wordId;
    protected String word,meaning;
    protected int isTeached,wrongCounter;


    public Words(int wordId) {
        this.wordId = wordId;
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

    private Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    protected String getWord(){
        return word;
    }
    protected String getMeaning(){
        return meaning;
    }
    protected int getIsTeached(){
        return isTeached;
    }
    protected int getWrongCounter(){
        return wrongCounter;
    }
    protected void setIsTeached(int isTeached){
        this.isTeached = isTeached;
    }
    protected void setWrongCounter(int wrongCounter){
        this.wrongCounter = wrongCounter;
    }



}
