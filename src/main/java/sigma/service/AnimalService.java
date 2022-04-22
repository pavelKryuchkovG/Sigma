package sigma.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AnimalService {

    Map<String, List<String>> writeNewAnimals(String suggestedAnimalName);

    boolean isRightAnimalName(Set<String> suggestedAnimalNameSet, String animalName);

    boolean addSuggestedAnimalName(Set<String> suggestedName, String animalName);

    boolean isFoundAnimal();
}
