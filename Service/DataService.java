package Service;

import Model.Animal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface DataService {
    List<Animal> getAllAnimals(); // Список всех животных
    List<Animal> getAllAnimalsSortBirth() throws ParseException; // Список всех животных отсортированный по дате рождения
    ArrayList getAllAnimalsForCommand();
    Integer countAnimals(); // Количество животных
    Integer countTypeAnimals(TypeAnimal typeAnimal); // Количество животных заданного типа
    void addAnimal(TypeAnimal type, String animalName, String breedAnimal, Birth dateOfBirth, ArrayList commands); // Добавить животное
    void learnCommand(ArrayList list); // Обучить команде
    ArrayList getListCommands(Integer idNum); // Показать список команд животного
}