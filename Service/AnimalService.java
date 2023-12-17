package Service;

import Model.*;

import java.text.ParseException;
import java.util.*;

public class AnimalService implements DataService {
    List<Animal> animalList = new ArrayList<>();

    @Override
    public List<Animal> getAllAnimals() {
        return animalList;
    }

    @Override
    public List<Animal> getAllAnimalsSortBirth() throws ParseException {
        ArrayList<Date> arrBirth = new ArrayList<>();
        ArrayList arrDateSorts = new ArrayList<>();
        List<Animal> resSortsBirth = new ArrayList<>();

        // Добавляем каждую дату в arrBirth
        ReverseBirth reverseBirth = new ReverseBirth();
        for (Animal animal : animalList) {
            arrBirth.add(reverseBirth.stringToDate(String.valueOf(animal.getDateOfBirth())));
        }

        // Сортируем по дате (по возрастанию) используя метод sortAscending класса Sorting
        Sorting sortAscending = new Sorting();
        arrDateSorts = sortAscending.sortAscending(arrBirth);

        // Переводим arrDateSorts в лист стрингов
        ArrayList<String> stringArrayDate = new ArrayList<>();
        for (Object arr : arrDateSorts) {
            stringArrayDate.add(reverseBirth.dateToString((Date) arr));
        }

        // Ставим в возрастающем порядке элементы animalList в resSortsBirth
        String[] arrTempAnimal = new String[animalList.size()];
        List<String> tempAnimalList = new ArrayList<>();

        int countNum = 0;
        int forJ = 0;
        for (int i = 0; i < stringArrayDate.size(); i++) {
            for (forJ = 0; forJ < animalList.size(); forJ++) {
                if (resSortsBirth.size() == countNum + 1) {
                    countNum += 1;
                    forJ = 0;
                    break;
                }
                tempAnimalList.add(String.valueOf(animalList.get(forJ)));
                arrTempAnimal = tempAnimalList.get(forJ).replaceAll(",", "").split(" ");

                for (int k = 0; k < arrTempAnimal.length; k++) {
                    if (stringArrayDate.get(i).equals(arrTempAnimal[k])) {
                        resSortsBirth.add(animalList.get(forJ));

                        for (int a = 0; a < arrTempAnimal.length; a++) {
                            arrTempAnimal[a] = null;
                        }

                        int index = tempAnimalList.size(); //3
                        for (int t = 0; t < index; t++) {
                            tempAnimalList.remove(0);
                        }
                        forJ = -1;
                        break;
                    }
                }
            }
        }
        return idSort(resSortsBirth);
    }

    // Метод замены п/н в отсортированном листе по дате
    public ArrayList idSort(List<Animal> list) {
        ArrayList lll = new ArrayList();
        String[] arrTemp = new String[list.size()];
        ArrayList<String> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(String.valueOf(list.get(i)));
            arrTemp = arrayList.get(i).split(" ");

            for (int j = 1; j <= list.size(); j++) {
                if (arrTemp[2].equals(String.valueOf(j) + ",")) {
                    arrTemp[2] = String.valueOf(i + 1);
                }
            }
            lll.add(arrTemp);
        }
        return lll;
    }

    @Override
    public ArrayList getAllAnimalsForCommand() {
        ArrayList arrayList = new ArrayList();
        for (Animal animal : animalList) {
            arrayList.add(animal.getAnimalType());
            arrayList.add(animal.getAnimalName());
            arrayList.add(animal.getBreedAnimal());
            arrayList.add(animal.getDateOfBirth());
        }

        return arrayList;
    }

    @Override
    public Integer countAnimals() {
        return animalList.size();
    }

    @Override
    public Integer countTypeAnimals(TypeAnimal typeAnimal) {
        Integer count = 0;
        for (Animal animal : animalList) {
            if (animal.getAnimalType().equals(typeAnimal)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void addAnimal(TypeAnimal type, String animalName, String breedAnimal, Birth dateOfBirth, ArrayList commands) {
        int id = getId();
        if(type.equals(TypeAnimal.Dog)){
            Dog dog = new Dog(id, type, animalName, breedAnimal, dateOfBirth, commands);
            animalList.add(dog);
        }
        if(type.equals(TypeAnimal.Cat)){
            Cat cat = new Cat(id, type, animalName, breedAnimal, dateOfBirth, commands);
            animalList.add(cat);
        }
        if(type.equals(TypeAnimal.Hamster)){
            Hamster hamster = new Hamster(id, type, animalName, breedAnimal, dateOfBirth, commands);
            animalList.add(hamster);
        }
        if(type.equals(TypeAnimal.Parrot)){
            Parrot parrot = new Parrot(id, type, animalName, breedAnimal, dateOfBirth, commands);
            animalList.add(parrot);
        }
    }

    @Override
    public void learnCommand(ArrayList list) {
        int idAnimal = (int) list.get(0);
        String commandAnimal = (String) list.get(1);

        for (int i = 0; i < animalList.size(); i++) {
            animalList.get(idAnimal-1);
        }

        ArrayList oldNewCommands = new ArrayList();
        oldNewCommands = animalList.get(idAnimal-1).getCommands();
        oldNewCommands.add(commandAnimal);
        animalList.get(idAnimal-1).setCommands(oldNewCommands);
    }

    @Override
    public ArrayList getListCommands(Integer idNum) {
        ArrayList arrCommands = new ArrayList();
        for (int i = 0; i < animalList.size(); i++) {
            if (i == idNum) {
                arrCommands.add(animalList.get(i).getCommands());
            }
        }
        return arrCommands;
    }

    private int getId() {
        int lastId = 1;
        for (Animal animal : animalList) {
            lastId++;
        }
        return lastId;
    }
}