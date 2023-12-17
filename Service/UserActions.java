package Service;

import java.util.ArrayList;
import java.util.Scanner;

public class UserActions {
    public Integer getAllContacts() {
        Scanner scannerNum = new Scanner(System.in);
        System.out.println("Укажите 1, если хотите просмотреть список животных в обычном порядке;\n" +
                "Укажите 2, если хотите просмотреть список животных, отсортированный по дате рождения животного;\n" +
                "<<Укажите номер команды: >>");
        Integer num = scannerNum.nextInt();

        while (!num.equals(1) || !num.equals(2)) {
            if (num.equals(1)) {
                return 1;
            }
            if (num.equals(2)) {
                return 2;
            }
            System.out.println("Укажите один из представленных вариантов:\n" +
                    "Укажите 1, если хотите просмотреть список животных в обычном порядке;\n" +
                    "Укажите 2, если хотите просмотреть список животных, отсортированный по дате рождения животного;\n +" +
                    "<<Укажите номер команды: >>");
            num = scannerNum.nextInt();
        }
        return num;
    }

    public Integer countAnimals() {
        Scanner scannerNum = new Scanner(System.in);
        System.out.println("Укажите 1, если хотите просмотреть общее количество всех животных;\n" +
                "Укажите 2, если хотите просмотреть общее количество животных заданного вида.\n" +
                "<<Укажите номер команды: >>");
        Integer num = scannerNum.nextInt();

        while (!num.equals(1) || !num.equals(2)) {
            if (num.equals(1)) {
                return 1;
            }
            if (num.equals(2)) {
                return 2;
            }
            System.out.println();
            System.out.println("Укажите один из представленных вариантов:\n" +
                    "Укажите 1, если хотите просмотреть общее количество всех животных;\n" +
                    "Укажите 2, если хотите просмотреть общее количество животных заданного вида.\n" +
                    "<<Укажите номер команды: >>");
            num = scannerNum.nextInt();
        }
        return num;
    }

    public TypeAnimal countTypeAnimals() {
        Scanner scannerNum = new Scanner(System.in);
        System.out.println("Укажите 1, если хотите просмотреть количество всех собак;\n" +
                "Укажите 2, если хотите просмотреть количество всех котов;\n" +
                "Укажите 3, если хотите просмотреть количество всех хомяков;\n" +
                "Укажите 4, если хотите просмотреть количество всех попугаев;\n" +
                "<<Укажите номер команды: >>");
        Integer numType = scannerNum.nextInt();
        while (!numType.equals(1) || !numType.equals(2) || !numType.equals(3) || !numType.equals(4)) {
            if (numType.equals(1)) {
                return TypeAnimal.Dog;
            }
            if (numType.equals(2)) {
                return TypeAnimal.Cat;
            }
            if (numType.equals(3)) {
                return TypeAnimal.Hamster;
            }
            if (numType.equals(4)) {
                return TypeAnimal.Parrot;
            }
            System.out.println();
            System.out.println("Укажите один из представленных вариантов:\n" +
                    "Укажите 1, если хотите просмотреть количество всех собак;\n" +
                    "Укажите 2, если хотите просмотреть количество всех котов;\n" +
                    "Укажите 3, если хотите просмотреть количество всех хомяков;\n" +
                    "Укажите 4, если хотите просмотреть количество всех попугаев;\n" +
                    "<<Укажите номер команды: >>");
            numType = scannerNum.nextInt();
        }
        return TypeAnimal.Dog;
    }

    public ArrayList addAnimal() {
        Scanner scannerNum = new Scanner(System.in);

        TypeAnimal type = searchType();

        System.out.print("Укажите имя животного: ");
        String nameNum = scannerNum.next();

        System.out.print("Укажите породу животного: ");
        String breedNum = scannerNum.next();

        System.out.println("Заполните дату рождения животного:\n" +
                "Укажите год рождения животного по формату YYYY:");
        int yearNum = scannerNum.nextInt();
        while (yearNum < 1000 || yearNum > 9999) {
            System.out.print("Ошибка! Укажите год рождения животного по формату YYYY:");
            yearNum = scannerNum.nextInt();
        }
        System.out.println("Укажите месяц рождения животного (с 1 по 12):");
        int monthNum = scannerNum.nextInt();
        while (monthNum < 1 || monthNum > 12) {
            System.out.print("Ошибка! Укажите месяц рождения животного (с 1 по 12):");
            monthNum = scannerNum.nextInt();
        }
        System.out.println("Укажите день рождения животного (с 1 по 31):");
        int dayNum = scannerNum.nextInt();
        while (dayNum < 1 || dayNum > 31) {
            System.out.print("Ошибка! Укажите день рождения животного (с 1 по 31):");
            dayNum = scannerNum.nextInt();
        }

        System.out.println("Укажите команду животного: ");
        String commandNum = scannerNum.next();
        CheckForNumber checkForNumber = new CheckForNumber();
        while (checkForNumber.isDigit(commandNum) == true){
            System.out.println("Ошибка! Укажите команду животного: ");
            commandNum = scannerNum.next();
        }

        ArrayList newAnimalDetails = new ArrayList();
        newAnimalDetails.add(type);
        newAnimalDetails.add(nameNum);
        newAnimalDetails.add(breedNum);
        newAnimalDetails.add(yearNum);
        newAnimalDetails.add(monthNum);
        newAnimalDetails.add(dayNum);
        newAnimalDetails.add(commandNum);

        return newAnimalDetails;
    }

    public TypeAnimal searchType() {
        System.out.println("Укажите тип животного:\n" +
                "1 - Собака\n2 - Кошка\n3 - Хомяк\n4 - Попугай");

        Scanner scannerNum = new Scanner(System.in);
        TypeAnimal type = TypeAnimal.Dog;
        Integer typeNum = scannerNum.nextInt();

        while (!typeNum.equals(1) || !typeNum.equals(2) || !typeNum.equals(3) || !typeNum.equals(4)) {
            if (typeNum.equals(1)) {
                return TypeAnimal.Dog;
            }
            if (typeNum.equals(2)) {
                return TypeAnimal.Cat;
            }
            if (typeNum.equals(3)) {
                return TypeAnimal.Hamster;
            }
            if (typeNum.equals(4)) {
                return TypeAnimal.Parrot;
            }

            System.out.println("Ошибка!\nУкажите тип животного:\n" +
                    "1 - Собака\n2 - Кошка\n3 - Хомяк\n4 - Попугай");
            typeNum = scannerNum.nextInt();
        }
        return type;
    }

    // Показать список команд животного
    public Integer getListCommands(Integer size) {
        Scanner scannerNum = new Scanner(System.in);
        System.out.println();
        System.out.println("_______________________________________________________________");
        System.out.println("Укажите id животного, список команд которого хотите посмотреть:");
        Integer idNum = scannerNum.nextInt();
        while (idNum < 1 || idNum > size) {
            System.out.println();
            System.out.println("Ошибка!\nУкажите id животного, список команд которого хотите посмотреть:");
            idNum = scannerNum.nextInt();
        }
        return idNum - 1;
    }

    public ArrayList learnCommand(Integer size) {
        Scanner scannerNum = new Scanner(System.in);
        ArrayList list = new ArrayList();

        System.out.println();
        System.out.println("________________________________________________");
        System.out.println("Укажите id животного, которого хотите обучить:");

        Integer idNum = scannerNum.nextInt();
        while (idNum < 1 || idNum > size) {
            System.out.println();
            System.out.println("Ошибка!\nУкажите id животного, которого хотите обучить:");
            idNum = scannerNum.nextInt();
        }

        System.out.println("Укажите команду, которой хотите обучить животное");
        String command = scannerNum.next();

        list.add(idNum);
        list.add(command);

        return list;
    }
}