import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SideFrameQuestListener extends SideFrameQuests{
    private static void waiter(){

    }

    public static int returner = 0;
    public static void listener(int k){
        for (int i = 0 ; i < buttons.length ; i++){
            if (i == answerChoice){
                buttons[answerChoice].addActionListener(e -> {
                    for (int j = 0 ; j < buttons.length ; j++){
                        if (j == answerChoice){
                            System.out.println("Doğru butona bastınız");
                            label.setText("DOĞRU");
                            label.setForeground(Color.GREEN);
                            buttons[answerChoice].setContentAreaFilled(true);
                            buttons[answerChoice].setBorderPainted(false);
                            buttons[answerChoice].setOpaque(true);
                            buttons[answerChoice].setBackground(Color.GREEN);
                            buttons[answerChoice].setEnabled(false);
                            if (k == 0){
                                answerWord.setIsTeached(true);
                                answerWord.setWrongCounter(false);
                            }
                            else if(k == 1){
                                answerWord.setWrongCounter(false);
                                answerWord.setIsTeached(true);
                            }else if(k == 2){
                                answerWord.setIsTeached(true);
                            }
                            continue;
                        }
                        buttons[j].setContentAreaFilled(true);
                        buttons[j].setBorderPainted(false);
                        buttons[j].setOpaque(true);
                        buttons[j].setBackground(Color.RED);
                        buttons[j].setEnabled(false);


                    }

                    //3 saniye bekleme
                    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
                    System.out.println("Görev zamanlandı...");
                    scheduler.schedule(() -> {
                        ReturnerFrame.generateFrame(k);
                    }, 3, TimeUnit.SECONDS);
                    scheduler.shutdown();

                });

            }
            else {
                int finalI = i;
                SideFrameQuests.buttons[i].addActionListener(e -> {
                    System.out.println("yanlış butona bastınız");
                    for (int j = 0 ; j < buttons.length ; j++){
                        if (j == answerChoice){
                            label.setText("YANLIŞ");
                            label.setForeground(Color.RED);
                            buttons[j].setContentAreaFilled(true);
                            buttons[j].setBorderPainted(false);
                            buttons[j].setOpaque(true);
                            buttons[j].setBackground(Color.orange);
                            buttons[j].setEnabled(false);
                            answerWord.setIsTeached(false);
                            answerWord.setWrongCounter(true);
                            continue;
                        }
                        buttons[j].setContentAreaFilled(true);
                        buttons[j].setBorderPainted(false);
                        buttons[j].setOpaque(true);
                        buttons[j].setBackground(Color.red);
                        buttons[j].setEnabled(false);
                    }
                    int returner = 1;
                    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
                    System.out.println("Görev zamanlandı...");
                    scheduler.schedule(() -> {
                        ReturnerFrame.generateFrame(k);
                    }, 3, TimeUnit.SECONDS);
                    scheduler.shutdown();

                });

            }

        }
    }
}
