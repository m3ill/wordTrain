public class MainBtnEvent {

    public void listener(){
        MainFrameGenerator.MainButtons[0].addActionListener(e -> {
            LearnNewWord.generateFrame();
        });
        MainFrameGenerator.MainButtons[1].addActionListener(e -> {
            LearnWrongWord.generateFrame();
        });
        MainFrameGenerator.MainButtons[2].addActionListener(e -> {
            RepeatWord.generateFrame();
        });
        MainFrameGenerator.MainButtons[3].addActionListener(e -> {
            DayQuote.generateFrame();
        });
    }
}
