package org.example;

import org.example.controller.ProgramController;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        start();
        System.out.print("Если хотите попробовать подключиться ещё раз, напишите что-нибудь\n> ");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            scanner.nextLine();

            start();
            System.out.print("Если хотите попробовать подключиться ещё раз, напишите что-нибудь\n> ");
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