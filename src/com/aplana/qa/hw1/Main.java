package com.aplana.qa.hw1;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char isStart;
        System.out.println("Какое приложение запустить? Введите '1' для запуска Калькулятора, '2' для запуска Домино, '0' для выхода.");
        char answer = getAnswer();
        isStart = isStart(answer);
    }

    public static char getAnswer() {
        char answer;
        if (scanner.hasNext()) {
            answer = scanner.next().charAt(0);
        } else {
            scanner.next();
            answer = getAnswer();
        }
        return answer;
    }

    public static char isStart(char answer) {
        char result;
        switch (answer) {
            case '1':
                Calculator.main();
                result = 1;
                break;
            case '2':
                Domino.main();
                result = 2;
                break;
            case '0':
                result = 0;
                break;
            default:
                System.out.println("Ответ не распознан. Введите '1' для запуска Калькулятора, '2' для запуска Домино, '0' для выхода.");
                result = isStart(getAnswer());
        }
        return result;
    }
}