import javax.swing.*;
import java.awt.*;

public class ReturnerFrame {
    private static JButton[] button = {
            new JButton("Yeniden Oyna"),
            new JButton("Çık"),
    };
    private static JFrame frame = new JFrame();
    private static JLabel getLabel(){
        JLabel label = new JLabel("Yeniden oynamak ister misiniz ?",JLabel.LEFT);
        label.setFont(new Font("Segoe UI",Font.BOLD,16));
        label.setBounds(15,0,300,60);
        label.setOpaque(true);
        label.setBackground(new Color(224,230,235));
        return label;
    }
    private static void getButton(){

        for (JButton b : button){
            b.setBackground(new Color(220,228,227));
            b.setFont(new Font("Segoe UI",Font.BOLD,14));
        }
        button[0].setBounds(15,80,140,60);
        button[1].setBounds(160,80,150,60);
    }
    public static void generateFrame(int k){

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(340,200);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(224,230,235));
        frame.add(getLabel());
        getButton();
        for (JButton btn : button){
            frame.add(btn);
        }
        frame.setVisible(true);
        listener(k);
    }

    public static void listener(int k){

        for (var al : button[0].getActionListeners()) {
            button[0].removeActionListener(al);
        }
        for (var al : button[1].getActionListeners()) {
            button[1].removeActionListener(al);
        }
        
        button[0].addActionListener(e -> {
            frame.dispose();
            if (k == 0){
                LearnNewWord.frame.dispose();
                LearnNewWord.generateFrame();
                SideFrameQuestListener.listener(0);
            }
            else if (k == 1){
                LearnWrongWordFrame.frame.dispose();
                LearnWrongWordFrame.generateFrame();
                SideFrameQuestListener.listener(1);
            }
            else if (k == 2){
                RepeatWordFrame.frame.dispose();
                RepeatWordFrame.generateFrame();
                SideFrameQuestListener.listener(2);
            }

        });
        button[1].addActionListener(e -> {
            if (k == 0)
                LearnNewWord.frame.dispose();
            if (k == 1)
                LearnWrongWordFrame.frame.dispose();
            if (k == 2)
                RepeatWordFrame.frame.dispose();

            frame.dispose();
        });
    }
}
