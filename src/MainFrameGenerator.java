import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MainFrameGenerator {

    private static JFrame frame;
    private static ImageIcon splashIcon = new ImageIcon(MainFrameGenerator.class.getResource("/resources/Art.png"));
    private static ImageIcon appIcon = new  ImageIcon(MainFrameGenerator.class.getResource("/resources/iconWolf.png"));
    public static JLabel splashLabel;
    private static int frameWidth = 600, frameHeight = 310;
    public static ImageIcon[] BTNIcons = {
            new ImageIcon(MainFrameGenerator.class.getResource("/resources/StudentWolf.png")),
            new ImageIcon(MainFrameGenerator.class.getResource("/resources/WrongWolf.png")),
            new ImageIcon(MainFrameGenerator.class.getResource("/resources/RepeatWolf.png")),
            new ImageIcon(MainFrameGenerator.class.getResource("/resources/wiseWolf.png")),
    };
    public static JButton[] MainButtons = {
            new JButton("Yeni Kelime Öğren",BTNIcons[0]),
            new JButton("Yanlış kelimeler",BTNIcons[1]),
            new JButton("Tekrar Et",BTNIcons[2]),
            new JButton("Günün sözü",BTNIcons[3]),
    };


    //Sol üstteki logoyu boyutlandırma
    private static ImageIcon getResizedIcon(ImageIcon icon,int IconWidth, int IconHeight) {
        Image img = icon.getImage();
        img = img.getScaledInstance(IconWidth, IconHeight, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        return icon;
    }

    //boyutlandırılan logoyu bir etiket içerisine koyma ve yazı ekleme üst bar tasarımı
    private static void getArtLabel(){
        ImageIcon icon = getResizedIcon(splashIcon,80,80);
        splashLabel = new JLabel("Kelimeler, peşinden yılmadan koşan kurda teslim olur.",icon,JLabel.CENTER);
        splashLabel.setVerticalAlignment(SwingConstants.TOP);
        splashLabel.setHorizontalAlignment(SwingConstants.LEFT);
        splashLabel.setBackground(new Color(220,228,227));
        splashLabel.setFont(new Font("Segoe UI",Font.BOLD,16));
        splashLabel.setBounds(splashLabel.getX(),splashLabel.getY(),frameWidth,icon.getIconHeight());
        splashLabel.setOpaque(false);
    }

    //Butonların görünümünü ve konumlarını ayarlama
    private static void getBtns(){
        //resized Button art
        for(ImageIcon i : BTNIcons){
            Image img = i.getImage();
            img = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            i.setImage(img);
        }
        for (JButton btn : MainButtons){
            btn.setBackground(new Color(220,228,227));
            btn.setFont(new Font("Segoe UI",Font.BOLD,16));
            btn.setHorizontalAlignment(SwingConstants.LEFT);
        }
        MainButtons[0].setBounds(20,105,265,80);
        MainButtons[1].setBounds(295,105,265,80);
        MainButtons[2].setBounds(20,190,265,80);
        MainButtons[3].setBounds(295,190,265,80);
    }

    //frame ayarlarının yapılması ve diğer ögelerin fream'e eklenmesi
    private static void getFrame(){
        frame = new JFrame("Diloloji");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(frameWidth,frameHeight);
        frame.setIconImage(getResizedIcon(appIcon,200,200).getImage());
        frame.getContentPane().setBackground(new Color(224,230,235));
        frame.add(splashLabel);
        for (JButton btn : MainButtons){
            frame.add(btn);
        }
        frame.setVisible(true);
    }

    //fream'i oluşturma
    public static void generateFrame(){
        getArtLabel();
        getBtns();
        getFrame();
    }

}
