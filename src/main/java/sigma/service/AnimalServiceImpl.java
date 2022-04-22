package sigma.service;

import sigma.model.Animal;
import sigma.utils.AnimalReader;

import java.util.*;

public class AnimalServiceImpl implements AnimalService {

    private AnimalReader animalReader;
    private Animal animal;

    public AnimalServiceImpl(AnimalReader animalReader, Animal animal) {
        this.animalReader = animalReader;
        this.animal = animal;
    }

    public Map<String, List<String>> writeNewAnimals(String suggestedAnimalName) {
        List<String> listProperties = new ArrayList<>();

        String newAnimalName = animalReader.questionWhatRightAnswer();
        String question = animalReader.questionWhatProperty(newAnimalName, suggestedAnimalName);

        listProperties.add(newAnimalName);
        listProperties.add(suggestedAnimalName);

        Map<String, List<String>> animalsData = animal.getAnimalsData();
        animalsData.put(question, listProperties);
        animal.setAnimalsData(animalsData);

        return animalsData;
    }

    public boolean isRightAnimalName(Set<String> suggestedAnimalNameSet, String animalName) {
        if (addSuggestedAnimalName(suggestedAnimalNameSet, animalName)) return false;

        System.out.println("Это " + animalName + "?(Да/Нет)");
        animal.setSuggestedAnimalName(animalName);

        return isFoundAnimal();
    }

    public boolean addSuggestedAnimalName(Set<String> suggestedName, String animalName) {
        if (suggestedName.contains(animalName)) return true;
        else {
            suggestedName.add(animalName);
        }
        return false;
    }

    public boolean isFoundAnimal() {
        if (animalReader.checkYesNo()) {
            System.out.println("Отлично! Я угадал, кожаный мешок!");
            return true;
        }
        return false;
    }
}
