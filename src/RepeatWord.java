import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RepeatWord extends SideFrameQuest {


    protected static JLabel getSplashLabel(){
        JLabel label=new JLabel("Tekrar et",MainFrameGenerator.BTNIcons[3],JLabel.CENTER);
        label.setBounds(0,0,frameWidth,80);
        label.setOpaque(true);
        label.setBackground(new Color(224,230,235));
        label.setFont(new Font("Segoe UI",Font.BOLD,16));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }

    protected static void generateFrame(){
        JFrame frame = new JFrame("Tekrar et");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(frameWidth,frameWidth);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(224,230,235));
        frame.add(getSplashLabel());
        frame.add(getWordLabel());
        getButton();
        for (int i = 0; i < buttons.length; i++) {
            frame.add(buttons[i]);
        }
        frame.setVisible(true);
    }
}
