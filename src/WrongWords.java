import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class WrongWords extends Words{
    List<Integer> list = new ArrayList<Integer>();
    public WrongWords(){
        super();
        String sql = "SELECT id FROM words WHERE wrong_counter <> 0";

        //wrong_counter 0 dan farklı olanları listeye alındı
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next())
                list.add(rs.getInt("id"));

        }catch (Exception e) {
            System.out.println("hata : " + e.getMessage());
        }

        if (list.isEmpty()){
            System.out.println("hiç yanlış yapılmış kelime yok");
        }else{
            Random rand = new Random();
            int randAnsID = rand.nextInt(list.size());
            super.GenerateWord(list.get(randAnsID));
        }
    }

    @Override
    public void setIsTeached(boolean b) {
        if (b)
            this.isTeached = 1;
        else
            this.isTeached = 0;
        changeData();
    }
    @Override
    public void setWrongCounter(boolean b) {
        if (b)
            this.wrongCounter++;
        else
            this.wrongCounter = 0;
        changeData();
    }

}
