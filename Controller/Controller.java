package Controller;

import Model.Animal;
import Service.AnimalService;
import Service.Birth;
import Service.TypeAnimal;
import View.AnimalsView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private final AnimalService animalService = new AnimalService();
    private final AnimalsView animalsView = new AnimalsView();

    public List<Animal> getAllAnimals() {
        List<Animal> animals = animalService.getAllAnimals();
        for (Animal animal : animals) {
            Animal animal1 = (Animal) animal;
            animalsView.printConsole(animal1);
        }
        return animals;
    }

    public List<Animal> getAllAnimalsSortBirth() throws ParseException {
        ArrayList animals = (ArrayList) animalService.getAllAnimalsSortBirth();
        for (Object animal : animals) {
            System.out.println(Arrays.deepToString((Object[]) animal).replaceAll(",", "").replaceAll("\\[", "").replaceAll("]", ""));
        }
        return animals;
    }

    public void getAllAnimalsForCommand() {
        ArrayList arr = animalService.getAllAnimalsForCommand();
        int ind = 4;
        int indexCount = 2;
        System.out.print("1. ");
        for (int i = 0; i < arr.size(); i++) {
            if (i == ind) {
                System.out.println();
                System.out.print(indexCount + ". ");
                indexCount++;
                ind += 4;
            }
            if (i == arr.size() - 1) {
                System.out.print(arr.get(i));
            } else {
                System.out.print(arr.get(i) + ", ");
            }
        }
    }

    public void addAnimal(TypeAnimal type, String animalName, String breedAnimal, Birth dateOfBirth, ArrayList commands) {
        animalService.addAnimal(type, animalName, breedAnimal, dateOfBirth, commands);
    }

    public Integer countAnimals() {
        Integer num = animalService.countAnimals();
        return num;
    }

    public void countTypeAnimals(TypeAnimal type) {
        Integer num = animalService.countTypeAnimals(type);
        String typeStr = "";
        if (type.equals(TypeAnimal.Dog)) {
            typeStr = "собак";
        }
        if (type.equals(TypeAnimal.Cat)) {
            typeStr = "кошек";
        }
        if (type.equals(TypeAnimal.Hamster)) {
            typeStr = "хомяков";
        }
        if (type.equals(TypeAnimal.Parrot)) {
            typeStr = "попугаев";
        }
        System.out.println("Общее количество " + typeStr + ": " + num);
    }

    public void getListCommands(Integer idNum) {
        ArrayList arrCommands = animalService.getListCommands(idNum);
        for (Object arrCommand : arrCommands) {
            System.out.println(arrCommand);
        }
    }

    public void learnCommand(ArrayList list) {
        animalService.learnCommand(list);
        System.out.println("Животное обучено");
    }
}