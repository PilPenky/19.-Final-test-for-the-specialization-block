package Model;

import Service.Birth;
import Service.TypeAnimal;

import java.util.ArrayList;

public class Dog extends Animal {
    Integer dogId;
    public Dog(Integer dogId, TypeAnimal type, String animalName, String breedAnimal, Birth dateOfBirth, ArrayList commands) {
        super(type, animalName, breedAnimal, dateOfBirth, commands);
        this.dogId = dogId;
    }

    @Override
    public String toString() {
        return "Собака. " +
                "п/н.: " + dogId +
                ", Имя: '" + animalName + '\'' +
                ", Порода: '" + breedAnimal + '\'' +
                ", Дата рождения: " + dateOfBirth +
                ", Команды: " + commands.toString().replaceAll("^\\[|\\]$", "") +
                ".";
    }
}