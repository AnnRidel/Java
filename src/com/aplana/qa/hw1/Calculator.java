package com.aplana.qa.hw1;
import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main() {
        boolean isContinue;
        do {
            int num1 = getNum();
            char operation = getOperation();
            int num2 = getNum();
            String result = calculate(num1, num2, operation);
            System.out.println("Результат: " + num1 + operation + num2 + "=" + result);
            char answer = getAnswer();
            isContinue = isContinue(answer);
        }
        while (isContinue);
        System.out.println("Какое приложение запустить? Введите '1' для запуска Калькулятора, '2' для запуска Домино, '0' для выхода.");
        Main.isStart(Main.getAnswer());
    }

    public static int getNum() {
        int num;
        System.out.println("Введите целое число от −2147483648 до 2147483647 (без пробелов):");
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз. Число должно принадлежать диапазону от −2147483648 до 2147483647 (без пробелов):");
            scanner.next();
            num = getNum();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите операцию (+|-|*|/):");
        char operation;
        if (scanner.hasNext("[+*/-]")) {
            operation = scanner.next().charAt(0);
        } else {
            scanner.next();
            operation = getOperation();
        }

        return operation;
    }

    public static String calculate(int num1, int num2, char operation) {
        String result;
        switch (operation) {
            case '+':
                result = String.valueOf((long) num1 + (long) num2);
                break;
            case '-':
                result = String.valueOf((long) num1 - (long) num2);
                break;
            case '*':
                result = String.valueOf((long) num1 * (long) num2);
                break;
            case '/':
                if (num2 == 0) {
                    result = "Возникла ошибка при попытке разделить на 0";
                } else {
                    result = String.valueOf((double) num1 / (double) num2);
                }
                break;
            default:
                System.out.println("Операция не распознана. Введите операцию (+|-|*|/):");
                result = calculate(num1, num2, getOperation());
        }
        return result;
    }

    public static char getAnswer() {
        System.out.println("Выполнить ещё одну операцию? Y/N");
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
        return result;
    }
}