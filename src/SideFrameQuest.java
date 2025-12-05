import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class SideFrameQuest extends Words{

    protected static final int  frameWidth = 400;
    protected static final int  frameHeight = 400;

    public static int AnswerIndex;
    public static int AnswserChoice;

    protected static JButton[] buttons = new JButton[4];

    protected static void getButton(){
        //kelimeleri temsil ediyor
        int[] usedWords = new int[5];
        Random rand = new Random();
        //hangi şıkkın cevap olacağını rastgele alıyorum
        AnswserChoice = rand.nextInt(4);
        //cevap olan kelimenin indexini dolduruyorum yani kullanıldığını gösteriyorum
        usedWords[AnswerIndex] = 1;
        //bütün butonları rastgele cevap harici kelimeler ile dolduruyor
        for (int i = 0; i < buttons.length; i++) {
            int num = rand.nextInt(5);
            if (usedWords[num] == 0) {
                buttons[i] = new JButton(Word[num][1]);
                usedWords[num] = 1;
            }else {
                i--;
                continue;
            }
            buttons[i].setBackground(new Color(220,228,227));
            buttons[i].setFont(new Font("Segoe UI",Font.BOLD,16));
        }
        //cevap şıkkının yazısını cevap olan kelimeye eşitliyor
        buttons[AnswserChoice].setText(Word[AnswerIndex][1]);
        buttons[AnswserChoice].setBackground(Color.BLUE);

        //butonların konumları ayarlanıyor
        buttons[0].setBounds(20,200,150,40);
        buttons[1].setBounds(220,200,150,40);
        buttons[2].setBounds(20,300,150,40);
        buttons[3].setBounds(220,300,150,40);
    }
    protected static int getWordToLabel(){
        getWords();
        // want word eğer -1 ise sadece rastgele kelime almak için kullanıyor
        Random number = new Random();
        int RandNum = number.nextInt(5);
        AnswerIndex = RandNum;
        return RandNum;

    }
    protected static JLabel getWordLabel(){
        JLabel label = new JLabel(Word[getWordToLabel()][0],JLabel.CENTER);
        label.setBounds(80,80,(frameWidth-160),80);
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        label.setFont(new Font("Segoe UI",Font.BOLD,16));
        label.setOpaque(true);
        label.setBackground(new Color(224,230,235));
        return label;
    }

}
