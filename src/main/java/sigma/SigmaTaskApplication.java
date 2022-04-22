package sigma;

import sigma.model.Animal;
import sigma.service.FindAnimalService;
import sigma.service.FindService;
import sigma.utils.AnimalReader;
import sigma.utils.Keyboard;

public class SigmaTaskApplication {

    private static FindService findService;

    public static void main(String[] args) {
        initGame();
        while (findService.findAnswer());
    }

    private static void initGame() {
        Animal animal = new Animal();
        Keyboard keyboard = new Keyboard();
        findService = new FindAnimalService(new AnimalReader(keyboard), animal);
    }

}