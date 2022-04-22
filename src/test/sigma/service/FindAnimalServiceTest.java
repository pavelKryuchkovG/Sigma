package sigma.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sigma.model.Animal;
import sigma.utils.AnimalReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindAnimalServiceTest {

    AnimalReader animalReader;
    Animal animal;

    @BeforeEach
    void setUp() {
        animalReader = mock(AnimalReader.class);
        animal = mock(Animal.class);
    }

    @Test
    void findAnswer() {
        List<String> animalNameList = new ArrayList<>();
        animalNameList.add("Кот");
        animalNameList.add("Кит");
        HashMap<String, List<String>> animalsData = new HashMap<>();

        animalsData.put("Живет на суше", animalNameList);
        when(animalReader.checkYesNo()).thenReturn(true);
        when(animal.getAnimalsData()).thenReturn(animalsData);

        FindAnimalService findAnimalService = new FindAnimalService(animalReader, animal);
        assertTrue(findAnimalService.findAnswer());
    }
}