package sigma.utils;

public interface Reader {

    String questionWhatRightAnswer();

    String questionWhatProperty(String newAnimalName, String suggestedAnimalName);

    boolean checkYesNo();
}
