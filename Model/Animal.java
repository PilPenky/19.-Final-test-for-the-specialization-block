package Model;

import Service.Birth;
import Service.TypeAnimal;

import java.util.ArrayList;

public abstract class Animal {
    TypeAnimal animalType;
    String animalName;
    String breedAnimal;
    Birth dateOfBirth;

    public void setCommands(ArrayList commands) {
        this.commands = commands;
    }

    ArrayList commands;

    public Animal(TypeAnimal type, String animalName, String breedAnimal, Birth dateOfBirth, ArrayList commands) {
        this.animalType = type;
        this.animalName = animalName;
        this.breedAnimal = breedAnimal;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    public TypeAnimal getAnimalType() {
        return animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getBreedAnimal() {
        return breedAnimal;
    }

    public Birth getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList getCommands() {
        return commands;
    }
}