package ru.topacademy.lesson5;

import java.util.Scanner;


public class FieldOfMiracles {
    Scanner scanner = new Scanner(System.in);
    private String[] arrList = {"lucky", "storm", "hockey"};
    private int numHiddenWord = (int) (Math.random() * 3);
    private String hiddenWord = arrList[numHiddenWord];
    private int hiddenWordLength = hiddenWord.length();
    private String[] hiddenLetterList = new String[hiddenWordLength];
    int attempt = 5;

    public FieldOfMiracles() {

        createField(hiddenLetterList);
        startGame(attempt);
    }

    private void createField(String[] hiddenWordListChar) {
        for (int i = 0; i < hiddenWordListChar.length; i++) {
            hiddenWordListChar[i] = String.valueOf('_');
        }
    }

    private void startGame(int attempt) {
        System.out.println("Угадайте слово по буквам, у Вас есть " + attempt + " попыток. Длина слова " +
                hiddenWordLength +
                "\nВведите букву");

        while (hiddenWordLength != 0 || attempt != 0) {
            char hiddenLetter = scanner.next().charAt(0);
            boolean isGuessLetter = false;
            for (int i = 0; i < hiddenWord.length(); i++) {

                if (guessedTheLetter(hiddenLetter, hiddenWord.charAt(i), i)) {
                    hiddenWordLength--;
                    isGuessLetter = true;
                }
            }

            if (!isGuessLetter) {
                attempt--;
                if (attempt == 0) {
                    System.out.println("У Вас закончились попытки.");
                    return;
                }
                System.out.println("Не угадали. Попробуйте снова. У вас осталось " + attempt + " попыток.");
            }

            if (hiddenWordLength == 0) {
                System.out.println("Поздравляю Вы угадали слово!");
                return;
            }
        }
    }

    private boolean guessedTheLetter(char hiddenLetter, char c, int i) {
        boolean isGuess = false;

        if (hiddenLetter == c) {
            System.out.println("Вы угадали " + (i + 1) + " букву");
            isGuess = true;
        }
        if (isGuess) {
            hiddenLetterList[i] = String.valueOf(hiddenLetter);
            fillingTheField(hiddenLetterList);
            System.out.println();
        }
        return isGuess;
    }


    private void fillingTheField(String[] hiddenWordListChar) {
        for (String s : hiddenWordListChar) {
            System.out.print(s);
        }
    }
}
