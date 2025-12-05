import javax.swing.*;
import java.awt.*;

public class DayQuote {
    private static JFrame frame;
    private static int frameWidth,frameHeight;



    private static JLabel getLabel(){
        String Quote = "nereye dönersen dön götün hep arkandadır";
        JLabel label = new JLabel(Quote,MainFrameGenerator.BTNIcons[3],JLabel.CENTER);
        Dimension dim = label.getPreferredSize();
        frameWidth = dim.width+30;
        System.out.println(frameWidth);
        frameHeight = dim.height+35;
        System.out.println(frameHeight);
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
