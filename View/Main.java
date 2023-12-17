package View;

import Controller.Controller;
import Exceptions.MyIsException;
import Service.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        UserActions userActions = new UserActions();
        CheckForNumber checkForNumber = new CheckForNumber();

        controller.addAnimal(TypeAnimal.Dog, "Коржик", "Корги", new Birth(2017, 5, 9), new ArrayList<>(Set.of(CommandsAnimal.Бежать, CommandsAnimal.Прыгать, CommandsAnimal.Голос)));
        controller.addAnimal(TypeAnimal.Dog, "Сосиска", "Такса", new Birth(2019, 10, 25), new ArrayList<>(Set.of(CommandsAnimal.Бежать, CommandsAnimal.Прыгать)));
        controller.addAnimal(TypeAnimal.Dog, "Кусака", "Золотистый ретривер", new Birth(2020, 7, 3), new ArrayList<>(Set.of(CommandsAnimal.Бежать, CommandsAnimal.Прыгать)));
        controller.addAnimal(TypeAnimal.Cat, "Здоровяк", "Мейн-кун", new Birth(2020, 1, 16), new ArrayList<>(Set.of(CommandsAnimal.Голос)));
        controller.addAnimal(TypeAnimal.Cat, "Олик", "Дворянин", new Birth(2020, 6, 19), new ArrayList<>(Set.of(CommandsAnimal.Прыгать, CommandsAnimal.Бежать, "Спать")));
        controller.addAnimal(TypeAnimal.Cat, "Тёма", "Боевой дворянин", new Birth(2018, 6, 5), new ArrayList<>(Set.of(CommandsAnimal.Голос, CommandsAnimal.Стоять)));
        controller.addAnimal(TypeAnimal.Cat, "Скотик", "Бенгальский кот", new Birth(2023, 10, 12), new ArrayList<>(Set.of(CommandsAnimal.Бежать, CommandsAnimal.Прыгать)));
        controller.addAnimal(TypeAnimal.Hamster, "Хома", "Джунгарик", new Birth(2022, 11, 11), new ArrayList<>(Set.of(CommandsAnimal.Стоять, CommandsAnimal.Прыгать)));
        controller.addAnimal(TypeAnimal.Hamster, "Круч", "Китайский", new Birth(2022, 7, 28), new ArrayList<>(Set.of(CommandsAnimal.Стоять, CommandsAnimal.Голос, CommandsAnimal.Прыгать)));
        controller.addAnimal(TypeAnimal.Parrot, "Пират", "Ара", new Birth(2021, 4, 19), new ArrayList<>(Set.of(CommandsAnimal.Стоять, CommandsAnimal.Голос)));
        controller.addAnimal(TypeAnimal.Parrot, "Любовь", "Неразлучник", new Birth(2017, 4, 19), new ArrayList<>(Set.of(CommandsAnimal.Бежать, CommandsAnimal.Голос)));
        controller.addAnimal(TypeAnimal.Parrot, "Морковь", "Неразлучник", new Birth(2017, 8, 20), new ArrayList<>(Set.of(CommandsAnimal.Идти, CommandsAnimal.Голос)));


        System.out.println("Реестр домашних животных:\n" +
                "       1 - Показать полный список животных;\n" +
                "       2 - Показать количество животных;\n" +
                "       3 - Добавить животное;\n" +
                "       4 - Показать список команд животного;\n" +
                "       5 - Обучить новой команде животное;\n" +
                "       0 - Закрыть программу.\n" +
                "<<Укажите номер команды: >>");

        Scanner scanner = new Scanner(System.in);

        try {
            String numStr = scanner.next();
            while (checkForNumber.isDigit(numStr) == false) {
                System.out.println("Ошибка! Введите число.\n" +
                        "Реестр домашних животных:\n" +
                        "       1 - Показать полный список животных;\n" +
                        "       2 - Показать количество животных;\n" +
                        "       3 - Добавить животное;\n" +
                        "       4 - Показать список команд животного;\n" +
                        "       5 - Обучить новой команде животное;\n" +
                        "       0 - Закрыть программу.\n" +
                        "<<Укажите номер команды: >>");
                numStr = scanner.next();
            }
            Integer num = Integer.parseInt(numStr);

            while (!num.equals(0)) {

                if (num.equals(1)) {
                    Integer numAllContacts = userActions.getAllContacts();
                    if (numAllContacts.equals(1)) {
                        controller.getAllAnimals();
                    } else {
                        controller.getAllAnimalsSortBirth();
                    }
                }

                if (num.equals(2)) {
                    Integer numCountAnimals = userActions.countAnimals();
                    if (numCountAnimals.equals(1)) {
                        System.out.println("Общее количество животных: " + controller.countAnimals());
                    } else {
                        TypeAnimal typeAnimal = userActions.countTypeAnimals();
                        controller.countTypeAnimals(typeAnimal);
                    }
                }

                if (num.equals(3)) {
                    ArrayList newAnimalDetails = userActions.addAnimal();
                    TypeAnimal type = (TypeAnimal) newAnimalDetails.get(0);
                    String nameNum = (String) newAnimalDetails.get(1);
                    String breedNum = (String) newAnimalDetails.get(2);
                    int yearNum = (int) newAnimalDetails.get(3);
                    int monthNum = (int) newAnimalDetails.get(4);
                    int dayNum = (int) newAnimalDetails.get(5);
                    String commandNum = (String) newAnimalDetails.get(6);
                    controller.addAnimal(type, nameNum, breedNum, new Birth(yearNum, monthNum, dayNum), new ArrayList<>(Set.of(commandNum)));
                }

                if (num.equals(4)) {
                    controller.getAllAnimalsForCommand();
                    controller.getListCommands(userActions.getListCommands(controller.countAnimals()));
                }

                if (num.equals(5)) {
                    controller.getAllAnimalsForCommand();
                    controller.learnCommand(userActions.learnCommand(controller.countAnimals()));
                }

                if (num.equals(0)) {
                    return;
                }

                System.out.println();
                System.out.println("Реестр домашних животных:\n" +
                        "       1 - Показать полный список животных;\n" +
                        "       2 - Показать количество животных;\n" +
                        "       3 - Добавить животное;\n" +
                        "       4 - Показать список команд животного;\n" +
                        "       5 - Обучить новой команде животное;\n" +
                        "       0 - Закрыть программу.\n" +
                        "<<Укажите номер команды: >>");
                numStr = scanner.next();

                while (checkForNumber.isDigit(numStr) == false) {
                    System.out.println("Ошибка! Введите число.\n" +
                            "Реестр домашних животных:\n" +
                            "       1 - Показать полный список животных;\n" +
                            "       2 - Показать количество животных;\n" +
                            "       3 - Добавить животное;\n" +
                            "       4 - Показать список команд животного;\n" +
                            "       5 - Обучить новой команде животное;\n" +
                            "       0 - Закрыть программу.\n" +
                            "<<Укажите номер команды: >>");
                    numStr = scanner.next();
                }
                num = Integer.parseInt(numStr);
            }
            System.out.println("До свидания!");

        } catch (InputMismatchException e) {
            throw new MyIsException();
        }
    }
}