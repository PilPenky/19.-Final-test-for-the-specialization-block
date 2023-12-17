package Model;

import Service.Birth;
import Service.TypeAnimal;

import java.util.ArrayList;

public class Parrot extends Animal {
    Integer parrotId;

    public Parrot(Integer parrotId, TypeAnimal type, String animalName, String breedAnimal, Birth dateOfBirth, ArrayList commands) {
        super(type, animalName, breedAnimal, dateOfBirth, commands);
        this.parrotId = parrotId;
    }

    @Override
    public String toString() {
        return "Попугай. " +
                "п/н.: " + parrotId +
                ", Имя: '" + animalName + '\'' +
                ", Порода: '" + breedAnimal + '\'' +
                ", Дата рождения: " + dateOfBirth +
                ", Команды: " + commands.toString().replaceAll("^\\[|\\]$", "") +
                ".";
    }
}