import java.sql.*;

public class LearnWords extends Words{

    public LearnWords(int wordId) {
        super();
        GenerateWord(wordId);
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
