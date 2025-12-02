import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class Main {
    public static void main(String[] args) {


        //Splash Artı aldık
        ImageIcon ArtIcon = new ImageIcon(Main.class.getResource("/resources/Art.png"));
        Image img = ArtIcon.getImage();
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ArtIcon = new ImageIcon(img);

        //splash Art labela yerleştirildi ve konumu ayarlandı
        JLabel splashLabel = new JLabel("Kelimeler, peşinden yılmadan koşan kurda teslim olur.",ArtIcon,JLabel.CENTER);
        splashLabel.setVerticalAlignment(SwingConstants.TOP);
        splashLabel.setHorizontalAlignment(SwingConstants.LEFT);
        splashLabel.setBackground(new Color(220, 228, 227));
        splashLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        splashLabel.setBounds(splashLabel.getX(),splashLabel.getY(), 600, ArtIcon.getIconHeight());
        splashLabel.setOpaque(true);

        //Buttonlar
        ImageIcon[] BtnIcons = {
                new ImageIcon(Main.class.getResource("/resources/StudentWolf.png")),
                new ImageIcon(Main.class.getResource("/resources/WrongWolf.png")),
                new ImageIcon(Main.class.getResource("/resources/RepeatWolf.png")),
                new ImageIcon(Main.class.getResource("/resources/wiseWolf.png")),
        };
        for (ImageIcon i : BtnIcons) {
            img = i.getImage();
            img = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            i.setImage(img);
        }
        JButton[] Buttons = {
                new JButton("Yeni Kelime Öğren",BtnIcons[0]),
                new JButton("Yanlış Kelimeler",BtnIcons[1]),
                new JButton("Tekrar Et",BtnIcons[2]),
                new JButton("Günün Sözü", BtnIcons[3]),
        };
        for (JButton b : Buttons) {
            b.setBackground(new Color(220, 228, 227));
            b.setBorder(BorderFactory.createLineBorder(Color.black));
            b.setFont(new Font("Segoe UI", Font.BOLD, 16));
            b.setHorizontalAlignment(SwingConstants.LEFT);
        }
        Buttons[0].setBounds(20,105,265,80);
        Buttons[1].setBounds(295,105,265,80);
        Buttons[2].setBounds(20,190,265,80);
        Buttons[3].setBounds(295,190,265,80);

        //freame oluşturdu ve ayarları yapıldı
        JFrame frame = new JFrame("Diloloji");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(224,230,235));

        frame.setSize(600, 300);
        frame.add(splashLabel);
        for (JButton button : Buttons) {
            frame.add(button);
        }
        frame.setVisible(true);
    }
}