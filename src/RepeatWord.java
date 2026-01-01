import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RepeatWord extends Words{

    List<Integer> list = new ArrayList<Integer>();
    public RepeatWord() {
        super();
        String sql = "SELECT id FROM words WHERE is_teached <> 0";

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);){
            while(rs.next())
                list.add(rs.getInt("id"));

        }catch(Exception e){
            System.out.println("hata : " + e.getMessage());
        }
        if (list.isEmpty())
            System.out.printf("Hiç tekrar edilcecek kelime bulunamadı");
        else {
            Random rand = new Random();
            int randAnsID = rand.nextInt(list.size());
            super.GenerateWord(list.get(randAnsID));
        }
    }

    @Override
    public void setIsTeached(boolean isTeached) {
        if (isTeached)
            this.isTeached = 1;
        else
            this.isTeached = 0;
        changeData();
    }
    @Override
    public void setWrongCounter(boolean isWrong) {
        if (isWrong)
            this.wrongCounter++;
        else
            this.wrongCounter = 0;
        changeData();
    }


}
