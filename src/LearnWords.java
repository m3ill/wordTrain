import java.sql.*;

public class LearnWords extends Words{

    public LearnWords(int wordId) {
        super();
        GenerateWord(wordId);
    }
    private void changeData(){
        String query = "UPDATE words SET is_teached = ?, wrong_counter = ? WHERE id = ?";
        try(Connection conn = connect();
        PreparedStatement preStmt = conn.prepareStatement(query);){
            preStmt.setInt(1, isTeached);
            preStmt.setInt(2, wrongCounter);
            preStmt.setInt(3, wordId);
            preStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
        }
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
    @Override
    public void setIsTeached(boolean isTeached){
        if (isTeached)
            this.isTeached = 1;
        else
            this.isTeached = 0;

        changeData();
    }
    @Override
    public void setWrongCounter(boolean isWrong){
        if (isWrong)
            wrongCounter++;
        else
            wrongCounter = 0;

        changeData();
    }

}
