class Main {

    public static void main(String[] args) {
        CreateDB.generateDB();
        CreateDbQuote.generateDB();
        MainFrameGenerator.generateFrame();
        MainBtnEvent.listener();



    }


}