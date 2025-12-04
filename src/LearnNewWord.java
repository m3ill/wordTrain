import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.jar.JarEntry;

public class LearnNewWord {

    private static int  frameWidth=400;
    private static int  frameHeight=400;
    private static String[][] Words = new  String[5][2];
    private static JButton[] buttons = new JButton[4];


    private static void getButton(){
        for (int i = 0; i < buttons.length; i++) {
            Random rand = new Random();
            buttons[i] = new JButton(Words[rand.nextInt(5)][1]);
            buttons[i].setFont(new Font("Segoe UI", Font.BOLD, 20));
            buttons[i].setBackground(Color.GRAY);
        }
        buttons[0].setBounds(20,200,150,40);
        buttons[1].setBounds(220,200,150,40);
        buttons[2].setBounds(20,300,150,40);
        buttons[3].setBounds(220,300,150,40);
    }

    private static int getWordToLabel(){
        // şuan test için böyle yapıldı sonradan veri tabanı eklenecek
        Words[0][0] = "School";
        Words[0][1] = "Okul";
        Words[1][0] = "Hospital";
        Words[1][1] = "Hastane";
        Words[2][0] = "Word";
        Words[2][1] = "Kelime";
        Words[3][0] = "Computer";
        Words[3][1] = "Bilgisayar";
        Words[4][0] = "Engineer";
        Words[4][1] = "Mühendis";

        // want word eğer -1 ise sadece rastgele kelime almak için kullanıyor

        Random number = new Random();
        int RandNum = number.nextInt(5);
        System.out.println("RandNum: " + RandNum);
        System.out.println("Random word: " + Words[RandNum][0]);
        return RandNum;

    }
    public static JLabel getSplashLabel(){
        JLabel label=new JLabel("Yeni Kelime Öğren",MainFrameGenerator.BTNIcons[1],JLabel.CENTER);
        label.setBounds(0,0,frameWidth,80);
        label.setOpaque(true);
        label.setBackground(new Color(224,230,235));
        label.setFont(new Font("Segoe UI",Font.BOLD,16));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }
    public static JLabel getWordLabel(){
        JLabel label = new JLabel(Words[getWordToLabel()][0],JLabel.CENTER);
        label.setBounds(80,80,(frameWidth-160),80);
        label.setFont(new Font("Segoe UI",Font.BOLD,16));
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        label.setOpaque(true);
        label.setBackground(new Color(224,230,235));
        return label;
    }

    public static void generateFrame(){
        JFrame frame = new JFrame("Yeni Kelime Öğren");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
