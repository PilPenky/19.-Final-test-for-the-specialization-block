package Model;

import Service.Birth;
import Service.TypeAnimal;

import java.util.ArrayList;

public class Hamster extends Animal {
    Integer hamsterId;

    public Hamster(Integer hamsterId, TypeAnimal type, String animalName, String breedAnimal, Birth dateOfBirth, ArrayList commands) {
        super(type, animalName, breedAnimal, dateOfBirth, commands);
        this.hamsterId = hamsterId;
    }

    @Override
    public String toString() {
        return "Хомяк. " +
                "п/н.: " + hamsterId +
                ", Имя: '" + animalName + '\'' +
                ", Порода: '" + breedAnimal + '\'' +
                ", Дата рождения: " + dateOfBirth +
                ", Команды: " + commands.toString().replaceAll("^\\[|\\]$", "") +
                ".";
    }
}