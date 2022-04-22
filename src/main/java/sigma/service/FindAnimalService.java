package sigma.service;

import sigma.model.Animal;
import sigma.utils.AnimalReader;

import java.util.*;

public class FindAnimalService implements FindService {
    private AnimalReader animalReader;
    private Animal animal;
    private boolean isFoundAnimal;
    private AnimalService animalService;

    private static final Integer FIRST_INDEX_YES_ANSWER = 0;
    private static final Integer SECOND_INDEX_NO_ANSWER = 1;

    public FindAnimalService(AnimalReader reader, Animal animal) {
        this.animalReader = reader;
        this.animal = animal;
        this.animalService = new AnimalServiceImpl(animalReader, animal);
    }

    public boolean findAnswer() {
        isFoundAnimal = false;
        Set<String> SuggestedAnimalNameSet = new HashSet<>();
        System.out.println("Загадай животное, а я попробую угадать...(Да/Нет)");
        if (animalReader.checkYesNo()) {

            isFoundAnimal = animal.getAnimalsData().entrySet().stream().anyMatch((entry) -> {
                String question = entry.getKey();
                List<String> animalNameList = entry.getValue();
                System.out.println("Это животное " + question + "?(Да/Нет)");
                if (animalReader.checkYesNo()) {
                    String animalName = animalNameList.get(FIRST_INDEX_YES_ANSWER);
                    return animalService.isRightAnimalName(SuggestedAnimalNameSet, animalName);
                } else {
                    String animalName = animalNameList.get(SECOND_INDEX_NO_ANSWER);
                    return animalService.isRightAnimalName(SuggestedAnimalNameSet, animalName);
                }

            });

            if (!isFoundAnimal) {
                animalService.writeNewAnimals(animal.getSuggestedAnimalName());
            }

            System.out.println("Конец игры!");

        } else return false;

        return true;
    }

}
