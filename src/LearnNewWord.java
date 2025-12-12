import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.jar.JarEntry;

public class LearnNewWord extends SideFrameQuests {


    public static void generateQuest(JFrame frame) {
        frame.add(getSplashLabel());
        frame.add(setWordLabel(0));
        getButton();
        for (int i = 0; i < buttons.length; i++) {
            frame.add(buttons[i]);
        }
    }
    private static JLabel getSplashLabel(){
        JLabel label=new JLabel("Yeni Kelime Öğren",MainFrameGenerator.BTNIcons[0],JLabel.CENTER);
        label.setBounds(0,0,frameWidth,80);
        label.setOpaque(true);
        label.setBackground(new Color(224,230,235));
        label.setFont(new Font("Segoe UI",Font.BOLD,16));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }
    public static void generateFrame(){
        frame = new JFrame("Learn New Word");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(frameWidth,frameWidth);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(224,230,235));
        generateQuest(frame);
        frame.setVisible(true);
    }

}
