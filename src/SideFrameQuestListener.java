import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.sql.SQLOutput;

public class SideFrameQuestListener extends SideFrameQuests{
    public static int returner = 0;
    public static void listener(int k){
        for (int i = 0 ; i < buttons.length ; i++){
            if (i == answerChoice){
                buttons[answerChoice].addActionListener(e -> {
                    for (int j = 0 ; j < buttons.length ; j++){
                        if (j == answerChoice){
                            System.out.println("Doğru butona bastınız");
                            buttons[answerChoice].setBackground(Color.green);
                            buttons[answerChoice].setEnabled(false);
                            continue;
                        }
                        buttons[j].setBackground(Color.red);
                        buttons[j].setEnabled(false);
                        answerWord.setWrongCounter(false);
                        answerWord.setIsTeached(true);
                    }
                    ReturnerFrame.generateFrame(k);
                });

            }
            else {
                int finalI = i;
                SideFrameQuests.buttons[i].addActionListener(e -> {
                    System.out.println("yanlış butona bastınız");
                    for (int j = 0 ; j < buttons.length ; j++){
                        if (j == answerChoice){
                            buttons[j].setBackground(Color.orange);
                            buttons[j].setEnabled(false);
                            answerWord.setWrongCounter(true);
                            continue;
                        }
                        buttons[j].setBackground(Color.red);
                        buttons[j].setEnabled(false);
                    }
                    int returner = 1;
                    ReturnerFrame.generateFrame(k);
                });

            }

        }
    }
}
