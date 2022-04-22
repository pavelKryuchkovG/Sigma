package sigma.model;

import java.util.*;

public class Animal {

    private Map<String, List<String>> animalsData;
    private String suggestedAnimalName;

    public Animal() {
        List<String> animalNameList = new ArrayList<>();
        animalNameList.add("Кот");
        animalNameList.add("Кит");

        animalsData = new HashMap<>();
        animalsData.put("Живет на суше", animalNameList);
    }

    public Map<String, List<String>> getAnimalsData() {
        return animalsData;
    }

    public String getSuggestedAnimalName() {
        return suggestedAnimalName;
    }

    public void setAnimalsData(Map<String, List<String>> animalsData) {
        this.animalsData = animalsData;
    }

    public void setSuggestedAnimalName(String suggestedAnimalName) {
        this.suggestedAnimalName = suggestedAnimalName;
    }
}
