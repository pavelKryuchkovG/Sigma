package sigma.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import sigma.model.Animal;
import sigma.utils.AnimalReader;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnimalServiceImplTest {

    AnimalReader animalReader;

    @BeforeEach
    void setUp() {
        animalReader = mock(AnimalReader.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Собака", "Кот"})
    void writeNewAnimals(String suggestedAnimalName) {
        String newAnimalName = "Обезьяна";

        when(animalReader.questionWhatRightAnswer())
                .thenReturn(newAnimalName);
        when(animalReader.questionWhatProperty(newAnimalName, suggestedAnimalName))
                .thenReturn("Ест бананы");

        AnimalServiceImpl animalService = new AnimalServiceImpl(animalReader, new Animal());

        Map<String, List<String>> animalsData = animalService.writeNewAnimals(suggestedAnimalName);

        assertEquals(2, animalsData.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Собака", "Обезьяна"})
    void isRightAnimalName(String animalName) {

        when(animalReader.checkYesNo())
                .thenReturn(true);
        AnimalServiceImpl animalService = new AnimalServiceImpl(animalReader, new Animal());
        boolean isRightAnimal = animalService.isRightAnimalName(new HashSet<>(), animalName);

        assertTrue(isRightAnimal);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Кот", "Обезьяна"})
    void addSuggestedAnimalName(String animalName) {

        when(animalReader.checkYesNo())
                .thenReturn(true);
        AnimalServiceImpl animalService = new AnimalServiceImpl(animalReader, new Animal());
        boolean isSuggestedName = animalService.addSuggestedAnimalName(Set.of(animalName), animalName);

        assertTrue(isSuggestedName);
    }

    @Test
    void isFoundAnimal() {

        when(animalReader.checkYesNo())
                .thenReturn(true);
        AnimalServiceImpl animalService = new AnimalServiceImpl(animalReader, new Animal());
        boolean isFoundAnimal = animalService.isFoundAnimal();

        assertTrue(isFoundAnimal);
    }
}