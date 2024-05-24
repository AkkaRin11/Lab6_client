package org.example.controller;


import org.example.model.*;

import java.time.LocalDateTime;
import java.util.*;

import static org.example.util.Validation.checkIntNumber;

/**
 *
 * Класс-прослойка между выводом объектов и командами
 *
 */

public class ObjectController {
    private final ConsoleController consoleController = ConsoleController.getInstance();


    public LabWork getLabWorkObj() {
        LabWork lb = new LabWork((int) (Math.random() * Integer.MAX_VALUE), null, null, null, -1, null, null, null);

        lb.setName(consoleController.readString("name"));

        Coordinates coordinatesDto = new Coordinates(null, null);

        while (coordinatesDto.getX() == null) {
            Double a = consoleController.readDouble("x", "число должно быть меньеше 365");
            if (a == null){
                return null;
            }

            if (a < 365) {
                coordinatesDto.setX(a);
            } else {
                consoleController.println("x должен быть вещственным числом меньеше 365");
            }
        }

        while (coordinatesDto.getY() == null) {
            Long a = consoleController.readLong("y", "число должно быть больше -592");

            if (a == null){
                return null;
            }

            if (a > -592) {
                coordinatesDto.setY(a);
            } else {
                consoleController.println("y может быть только целым числом больше -592");
            }
        }

        lb.setCoordinates(coordinatesDto);


        while (lb.getMinimalPoint() == -1) {
            Long a = consoleController.readLong("minimal point", "число должно быть больше 0");

            if (a == null){
                return null;
            }

            if (a > 0) {
                lb.setMinimalPoint(a);
            } else {
                consoleController.println("minimal point может быть только целым числом больше 0");
            }
        }


        while (lb.getAveragePoint() == null) {
            Long a = consoleController.readLong("average point", "число должно быть больше 0");

            if (a == null){
                return null;
            }

            if (a > 0) {
                lb.setAveragePoint(a);
            } else {
                consoleController.println("average point может быть только целым числом больше 0");
            }
        }


        lb.setDifficulty(consoleController.readEnum(Difficulty.class));


        Person personDto = new Person(null, null, -1, null, null);


        personDto.setName(consoleController.readString("name"));

        while (personDto.getBirthday() == null) {

            String line = consoleController.readNextLine("date(year month day): ");
            String[] str = line.split("\\s+");

            if (str.length != 3) {
                consoleController.println("Некорректное количество аргументов, ожидается 3, получено " + str.length);

                continue;
            }

            Integer a = 0;
            if (checkIntNumber(str[0])) {

                try {
                    a = Integer.parseInt(str[0]);
                } catch (Exception ignored) {
                    return null;
                }

            } else {
                consoleController.println("year может быть только положительным целым числом");
                continue;
            }

            Integer b = 0;
            if (checkIntNumber(str[0])) {

                try {
                    b = Integer.parseInt(str[0]);
                } catch (Exception ignored) {
                    return null;
                }

            } else {
                consoleController.println("month может быть только положительным целым числом");
                continue;
            }

            Integer c = 0;
            if (checkIntNumber(str[0])) {

                try {
                    c = Integer.parseInt(str[0]);
                } catch (Exception ignored) {
                    return null;
                }

            } else {
                consoleController.println("day может быть только положительным целым числом");
                continue;
            }

            Date date;

            try {
                Calendar calendar = new GregorianCalendar(a, b - 1, c);
                date = calendar.getTime();
            } catch (Exception e) {
                consoleController.println("date не валидна");
                continue;
            }


            personDto.setBirthday(date);
        }

        personDto.setHairColor(consoleController.readEnum(Color.class));

        personDto.setNationality(consoleController.readEnum(Country.class));

        lb.setAuthor(personDto);

        lb.setCreationDate(LocalDateTime.now());

        return lb;
    }

    public void print(String... str) {
        consoleController.println(str);
    }

    public boolean hasNext() {
        return consoleController.hasNext();
    }


    public String readString() {
        return consoleController.readString("");
    }

    public void printLabWorkObj(LabWork labWork) {
        consoleController.printLabWorkObj(labWork);

    }

    public void printLabWorkObjs(LinkedHashSet<LabWork> labWork) {
        consoleController.printLabWorkObjs(labWork);
    }
}
