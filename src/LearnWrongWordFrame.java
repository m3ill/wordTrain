import javax.swing.*;
import java.awt.*;

public class LearnWrongWordFrame extends SideFrameQuests {

    protected static JLabel getSplashLabel(){
        JLabel label=new JLabel("Yanlış Kelimeler",MainFrameGenerator.BTNIcons[1],JLabel.CENTER);
        label.setBounds(0,0,frameWidth,80);
        label.setOpaque(true);
        label.setBackground(new Color(224,230,235));
        label.setFont(new Font("Segoe UI",Font.BOLD,16));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }

    protected static void generateFrame(){
        frame = new JFrame("Yanlış Kelimeler");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(frameWidth,frameWidth);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(224,230,235));
        frame.add(getSplashLabel());
        frame.add(setWordLabel(1));
        getButton();
        for (int i = 0; i < buttons.length; i++) {
            frame.add(buttons[i]);
        }
        frame.setVisible(true);

    }

}
