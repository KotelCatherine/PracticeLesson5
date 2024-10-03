package ru.topacademy.lesson5;

import java.util.Scanner;

/**
 * Задача 1: Найти сумму элементов массива
 * Описание: Попросите пользователя ввести количество чисел, затем введите сами числа, сохраните их в массив, и найдите сумму всех чисел.
 * <p>
 * Задача 2: Найти наибольшее число в массиве
 * Описание: Пользователь вводит количество чисел и сами числа, программа сохраняет их в массив и находит наибольшее число.
 * <p>
 * Задача: "Поле чудес"
 * Условия:
 * 1. Программа случайным образом выбирает слово из заданного списка.
 * 2. Пользователь вводит буквы для угадывания.
 * 3. Если буква присутствует в слове, она открывается в правильных позициях.
 * 4. Если буквы нет, программа выводит сообщение о неверном угадывании.
 * 5. У пользователя есть ограниченное количество попыток для угадывания неверных букв.
 * 6. Игра продолжается до тех пор, пока пользователь не угадает все буквы или не исчерпает попытки.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Игра \"Поле чудес\"");
        new FieldOfMiracles();

        System.out.println("\n==========================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int arrayLength = scanner.nextInt();
        int[] arrayNum = new int[arrayLength];
        int sum = 0;

        System.out.println("\nВведите числа содержащиеся в массиве: ");

        for (int i = 0; i < arrayNum.length; i++) {
            arrayNum[i] = scanner.nextInt();
        }

        int maxNum = arrayNum[0];
        for (int num : arrayNum) {
            sum += num;

            if (maxNum < num) {
                maxNum = num;
            }
        }

        System.out.println("Сумма всех чисел: " + sum + "\nМаксимальное число: " + maxNum);
    }
}