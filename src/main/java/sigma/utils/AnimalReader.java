package sigma.utils;

public class AnimalReader implements Reader {

    private Keyboard keyboard;

    public AnimalReader(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public String questionWhatRightAnswer() {
        System.out.println("Я сдаюсь, какое животное ты загадал?");
        return keyboard.getDataFromKeyBoard();
    }

    public String questionWhatProperty(String newAnimalName, String suggestedAnimalName) {
        System.out.println("Чем " + newAnimalName + " отличается от " + suggestedAnimalName + "?");
        return keyboard.getDataFromKeyBoard();
    }

    public boolean checkYesNo() {
        String inputText = keyboard.getDataFromKeyBoard();
        return "да".equals(inputText.toLowerCase());
    }


}
