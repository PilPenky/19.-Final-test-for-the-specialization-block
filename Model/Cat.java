package Model;

import Service.Birth;
import Service.TypeAnimal;

import java.util.ArrayList;

public class Cat extends Animal {
    Integer catId;

    public Cat(Integer catId, TypeAnimal type, String animalName, String breedAnimal, Birth dateOfBirth, ArrayList commands) {
        super(type, animalName, breedAnimal, dateOfBirth, commands);
        this.catId = catId;
    }

    @Override
    public String toString() {
        return "Кошка. " +
                "п/н.: " + catId +
                ", Имя: '" + animalName + '\'' +
                ", Порода: '" + breedAnimal + '\'' +
                ", Дата рождения: " + dateOfBirth +
                ", Команды: " + commands.toString().replaceAll("^\\[|\\]$", "") +
                ".";
    }
}