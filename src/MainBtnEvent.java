import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainBtnEvent {

    public static void listener(){
        MainFrameGenerator.MainButtons[0].addActionListener(e -> {
            LearnNewWord.generateFrame();
            SideFrameQuestListener.listener(0);
        });
        MainFrameGenerator.MainButtons[1].addActionListener(e -> {
            LearnWrongWordFrame.generateFrame();
            SideFrameQuestListener.listener(1);
        });
        MainFrameGenerator.MainButtons[2].addActionListener(e -> {
            RepeatWordFrame.generateFrame();
            SideFrameQuestListener.listener(2);
        });
        MainFrameGenerator.MainButtons[3].addActionListener(e -> {
            DayQuote.generateFrame();
        });
    }
}
