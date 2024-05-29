package org.example;

import org.example.controller.ProgramController;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        start();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            System.out.print("Если хотите попробовать подключиться ещё раз, напишите что-нибудь\n> ");

            scanner.nextLine();

            start();
        }

    }

    public static void start(){
        try {
            ProgramController cn = new ProgramController();
            cn.run();
        } catch (Exception exception){
            System.out.println("Сервер не запущен");
        }
    }
}