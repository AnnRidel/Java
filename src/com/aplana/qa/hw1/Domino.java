package com.aplana.qa.hw1;
import java.util.Arrays;
import java.util.Scanner;

public class Domino {
    static Scanner scanner = new Scanner(System.in);

    public static void main() {
        boolean isContinue;
        do {
            int num = getNum();
            int[][] domino = getDomino(num);
            System.out.println(Arrays.deepToString(domino));
            boolean isSequence = isSequence(domino);
            if (isSequence) System.out.println("Вы ввели правильную последовательность.");
            else System.out.println("Введённые домино не образуют последовательность.");
            char answer = getAnswer();
            isContinue = isContinue(answer);
        }
        while (isContinue);
        System.out.println("Какое приложение запустить? Введите '1' для запуска Калькулятора, '2' для запуска Домино, '0' для выхода.");
        Main.isStart(Main.getAnswer());
    }

    public static int getNum() {
        int num;
        System.out.println("Введите число костяшек (числовое значение от 1 до 28): ");
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа костяшек. Попробуйте еще раз. Число должно принадлежать диапазону от 1 до 28:");
            scanner.next();
            num = getNum();
        }
        if (num < 1 || num > 28){
                System.out.println("Вы допустили ошибку при вводе числа костяшек. Попробуйте еще раз. Число должно принадлежать диапазону от 1 до 28:");
                scanner.next();
                num = getNum();
        }
        return num;
    }

    public static int[][] getDomino(int num) {
        int[][] domino = new int[num][2];
        int a, b, c;
            for (int i = 0; i < num; i++) {
                System.out.println("Введите значение " + (i + 1) + " костяшки, разделив значение левой и правой сторон с помощью space/enter (пример: 0 6):");
                while (!scanner.hasNext("[0123456]")) {
                    System.out.println("Вы допустили ошибку при вводе значения костяшки. Попробуйте еще раз. Введите значение 1 костяшки, разделив значение левой и правой сторон с помощью space/enter (пример: 0 6):");
                    scanner.next();
                    i = 0;
                }
                if (i>0) {
                    a = scanner.nextInt();
                    b = scanner.nextInt();
                    for (c = 0; c < i; c++) {
                        if ((domino[c][0] == a && domino[c][1] == b) || (domino[c][1] == a && domino[c][0] == b) || (a<0)||(b<0)||(a>6)||(b>6)) {
                            i = -1;
                            c = 0;
                            System.out.println("Вы допустили ошибку при вводе значения костяшки. Попробуйте еще раз. Введите любой символ и нажмите Enter для продолжения.");
                            scanner.next();
                        } else {
                            domino[i][0] = a;
                            domino[i][1] = b;
                        }
                    }
                }
                else {
                    domino[i][0] = scanner.nextInt();;
                    domino[i][1] = scanner.nextInt();;
                }
            }
        return domino;
    }

    public static boolean isSequence (int[][] domino) {
        boolean result = false;
        int a, b;
        for (int i = 1; i < domino.length; i++) {
                a = domino[i][0];
                b = domino[i-1][1];
            result = a == b;
        }
        return result;
    }

    public static char getAnswer() {
        System.out.println("Попробовать ещё раз? Y/N");
        char answer;
        if (scanner.hasNext()) {
            answer = scanner.next().charAt(0);
        } else {
            scanner.next();
            answer = getAnswer();
        }
        return answer;
    }

    public static boolean isContinue(char answer) {
        boolean result;
        switch (answer) {
            case 'Y':
                result = true;
                break;
            case 'N':
                result = false;
                break;
            default:
                System.out.println("Ответ не распознан. Введите Y/N.");
                result = isContinue(getAnswer());
        }
        main();
        return result;
    }
}