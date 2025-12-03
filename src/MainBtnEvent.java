public class MainBtnEvent {

    public static void listener(){
        MainFrameGenerator.MainButtons[0].addActionListener(e -> {
            System.out.println("ilk butona basıldı");
        });
        MainFrameGenerator.MainButtons[1].addActionListener(e -> {
            System.out.println("2. butona basıldı");
        });
        MainFrameGenerator.MainButtons[2].addActionListener(e -> {
            System.out.println("3. butona basıldı");
        });
        MainFrameGenerator.MainButtons[3].addActionListener(e -> {
            DayQuote.generateFrame();
        });
    }
}
