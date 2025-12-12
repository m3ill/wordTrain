import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LearnFrameQuest extends SideFrameQuests {
    /*
    protected static final int  frameWidth = 400;
    protected static final int  frameHeight = 400;
    protected static JButton[] buttons = new JButton[4];
    protected static LearnWords answerWord;
    private static Words[] chanceWord = new LearnWords[4];
    public static int AnswerID;
    public static int answerChoice;


    protected static void generateRndDiffAnswer(){
        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            int num;
            boolean isDuplicate;

            do {
                num = (rand.nextInt(499) + 1);
                isDuplicate = false;

                if (num == answerWord.wordId) {
                    isDuplicate = true;
                    continue;
                }

                for(int j = 0; j < i; j++){
                    if (chanceWord[j] != null && num == chanceWord[j].wordId){
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);

            chanceWord[i] = new Words();
            chanceWord[i].GenerateWord(num);
            System.out.println("Oluşturulan Buton " + (i+1) + ": " + chanceWord[i].wordId + " " + chanceWord[i].word);
        }

    }
    protected static void getButton(){
        generateRndDiffAnswer();
        Random rand = new Random();
        //cevap olan seçenek
        answerChoice = rand.nextInt(4);

        for (int i = 0; i < buttons.length; i++) {
            String btnStr = chanceWord[i].meaning;
            btnStr= btnStr.replace("_" ," ");
            buttons[i] = new JButton(btnStr);
            buttons[i].setBackground(new Color(220,228,227));
            buttons[i].setFont(new Font("Segoe UI",Font.BOLD,16));
        }

        chanceWord[answerChoice] = answerWord;
        String btnStr = chanceWord[answerChoice].meaning;
        btnStr = btnStr.replace("_" ," ");
        buttons[answerChoice].setText(btnStr);
        buttons[answerChoice].setBackground(Color.BLUE);

        //butonların konumları ayarlanıyor
        buttons[0].setBounds(20,200,150,40);
        buttons[1].setBounds(220,200,150,40);
        buttons[2].setBounds(20,300,150,40);
        buttons[3].setBounds(220,300,150,40);
    }

    private static void getWordToLabel(){
        Random number = new Random();
        int RandNum = number.nextInt(500);
        AnswerID = RandNum;
        answerWord = new LearnWords(AnswerID);
        System.out.println("AnswerID: " + AnswerID + "word : " + answerWord.word);
    }
    // İ hangi quest çağırdığını temsil ediyor
    //i = 0 learnNewWord ; i = 1 LearnWrongWord ; i = 2 RepeatWord;
    protected static JLabel setWordLabel(){
        getWordToLabel();
        JLabel label = new JLabel(answerWord.word, JLabel.CENTER);
        label.setBounds(80,80,(frameWidth-160),80);
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        label.setFont(new Font("Segoe UI",Font.BOLD,16));
        label.setOpaque(true);
        label.setBackground(new Color(224,230,235));
        return label;
    }
    */
}
