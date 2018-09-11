/* ##########################################
# ДЗ к третьему уроку по Java на GeekBrains #
# ========================================= #
# Задача №1                                #
#                                           #
########################################## */

package ru.com.GeekBrains.Lesson3;

/*1.Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
    При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
    После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static Scanner input = new Scanner(System.in);
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 9;

    public static void main(String[] args) {

        int attempts = 3;
        boolean flag;

        do {
            mainGame(attempts);
            System.out.println("Повторить игру еще раз? (1 – да / 0 – нет)");
            int answer = input.nextInt();
            switch (answer) {
                case 1: {
                    flag = true;
                    break;
                }
                default: {
                    System.out.println("Всего хорошего!");
                    flag = false;
                }
            }
        } while (flag);

    }

    public static void mainGame(int attempts) {
        //int number = (int) (Math.random() * UPPER_LIMIT);
        int number = new Random().nextInt(UPPER_LIMIT + 1);
        System.out.printf("Приветствую! Я загадал число от %d до %d. Угадай его.\n", LOWER_LIMIT, UPPER_LIMIT);

        while (attempts > 0) {
            int myNumber = input.nextInt();
            attempts--;
            if (myNumber == number) {
                System.out.println("Ты угадал моё число. Молодец!");
                break;
            } else {
                if (myNumber < number) {
                    System.out.printf("Моё число больше. Осталось %d попыток\n", attempts);
                } else System.out.printf("Моё число меньше. Осталось %d попыток\n", attempts);
            }
            if (attempts == 0) {
                System.out.println("Ты не угадал моё число.");
            }
        }

    }
}
