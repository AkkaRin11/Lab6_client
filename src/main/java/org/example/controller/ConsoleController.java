package org.example.controller;


import org.example.model.LabWork;

import java.util.LinkedHashSet;
import java.util.Scanner;

import static org.example.util.Validation.checkDouble;
import static org.example.util.Validation.checkIntNumber;

/**
 *
 * Реализация StreamController для взаимодействия с консолью
 *
 */

public class ConsoleController{
    private static ConsoleController instance;
    private final Scanner sc;

    private ConsoleController() {
        sc = new Scanner(System.in);
    }

    public static ConsoleController getInstance() {
        if (instance == null) {
            instance = new ConsoleController();
        }

        return instance;
    }

    public void println(String... str) {
        print(str);
        System.out.println();
    }

    public void print(String... str) {
        for (String to : str) {
            System.out.print(to + " ");
        }
    }


    public boolean hasNext() {
        return sc.hasNext();
    }


    public String readNextLine() {
        return sc.nextLine();
    }


    public String readNextLine(String str) {
        println(str);
        return sc.nextLine();
    }


    public <T extends Enum<T>> T readEnum(Class<T> enumClass) {
        println("Введите одно из значений ниже");

        int it = 1;

        for (var to : enumClass.getEnumConstants()) {
            println("> " + it + " - " + to);
            it++;
        }

        T en = null;

        while (en == null) {
            println(enumClass.getSimpleName() + "(введите номер константы или её название): ");

            String line = readNextLine();

            if (line.isEmpty()) {
                println(enumClass.getSimpleName() + " не может быть пустой строкой");
                continue;
            }

            T a;

            try {

                if (checkIntNumber(line)){
                     int enumNumber = Integer.parseInt(line);

                     if (enumNumber > 0 && enumNumber <= enumClass.getEnumConstants().length){
                        a = enumClass.getEnumConstants()[enumNumber-1];
                     } else {
                         println("Такого значения для " + enumClass.getSimpleName() + " не существует");
                         continue;
                     }

                } else {
                    a = T.valueOf(enumClass, line.toUpperCase());
                }

            } catch (Exception e) {
                println("Такого значения для " + enumClass.getSimpleName() + " не существует");
                continue;
            }

            en = a;
        }

        return en;
    }

    public Long readLong(String name) {
        Long res = null;

        while (res == null) {
            println(name + "(введите целое число): ");

            String line = readNextLine();
            String[] str = line.split("\\s+");

            if (str.length != 1) {
                println("Некорректное количество аргументов");
                continue;
            }

            if (checkIntNumber(str[0])) {

                long a = 0;

                try {
                    a = Long.parseLong(str[0]);
                } catch (Exception ignored) {
                }

                res = a;
            } else {
                println(name + " может быть только целым числом");
            }
        }

        return res;
    }


    public Long readLong(String name, String text) {
        Long res = null;

        while (res == null) {
            println(name + "(введите целое число, " + text + "): ");

            String line = readNextLine();
            String[] str = line.split("\\s+");

            if (str.length != 1) {
                println("Некорректное количество аргументов");
                continue;
            }

            if (checkIntNumber(str[0])) {

                long a = 0;

                try {
                    a = Long.parseLong(str[0]);
                } catch (Exception ignored) {
                }

                res = a;
            } else {
                println(name + " может быть только целым числом");
            }
        }

        return res;
    }


    public Double readDouble(String name) {
        Double res = null;

        while (res == null) {
            println(name + "(введиет вещественное число): ");

            String line = readNextLine().replaceAll(",", ".");
            String[] str = line.split("\\s+");

            if (str.length != 1) {
                println("Некорректное количество аргументов");
                continue;
            }

            if (checkDouble(str[0]) || checkIntNumber(str[0])) {

                double a = 0;

                try {
                    a = Double.parseDouble(str[0]);
                } catch (Exception ignored) {
                }

                res = a;
            } else {
                println(name + " должен быть вещственным числом");
            }
        }

        return res;
    }

    public Double readDouble(String name, String text) {
        Double res = null;

        while (res == null) {
            println(name + "(введите вещественное число, " + text + "): ");

            String line = readNextLine().replaceAll(",", ".");
            String[] str = line.split("\\s+");

            if (str.length != 1) {
                println("Некорректное количество аргументов");
                continue;
            }

            if (checkDouble(str[0]) || checkIntNumber(str[0])) {

                double a = 0;

                try {
                    a = Double.parseDouble(str[0]);
                } catch (Exception ignored) {
                }

                res = a;
            } else {
                println(name + " должен быть вещственным числом");
            }
        }

        return res;
    }


    public String readString(String name) {
        String str = "";

        while (str.isEmpty()) {
            println(name + "(Введите строку): ");

            String line = readNextLine();

            if (line.isEmpty()) {
                println("Строка не может быть пустой");
                continue;
            }

            str = line;
        }

        return str;
    }


    public void printLabWorkObj(LabWork labWork) {
        println(labWork.toString());

    }


    public void printLabWorkObjs(LinkedHashSet<LabWork> labWork) {
        for (LabWork to : labWork) {
            printLabWorkObj(to);
        }

        if (labWork.isEmpty()) {
            println("Коллекция пуста");
        }
    }
}
