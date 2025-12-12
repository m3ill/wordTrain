import javax.swing.*;
import java.awt.*;

public class DayQuote {
    private static JFrame frame;
    private static int frameWidth,frameHeight;



    private static JLabel getLabel(){
        Quotes quote = new Quotes();
        JLabel label = new JLabel(quote.sentence,MainFrameGenerator.BTNIcons[3],JLabel.CENTER);
        Dimension dim = label.getPreferredSize();
        frameWidth = dim.width+30;
        frameHeight = dim.height+35;
        label.setBounds(0,0,dim.width,dim.height);
        return label;
    }

    public static void generateFrame(){
        frame = new JFrame("Günün Sözü");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.add(getLabel());
        frame.setSize(frameWidth,frameHeight);
        frame.getContentPane().setBackground(new Color(224,230,235));
        frame.setVisible(true);
    }
}
