/* ############################################
# ДЗ к четвёртому уроку по Java на GeekBrains #
# =========================================== #
# Задача №1                                  #
#                                             #
############################################ */

package ru.com.GeekBrains.Lesson4;

/* Крестики-нолики в процедурном стиле
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final int FIELD_SIZE = 5;         // размер игрового поля
    public static final int DOTS_TO_WIN = 4;        // сколько ячеек нужно подряд заполнить, чтобы победить

    public static final char EMPTY_DOT = '.';       // заполнитель для пустой ячейки
    public static final char PLAYER_1_DOT = 'X';    // символ, которым играет первый игрок
    public static final char PLAYER_2_DOT = 'O';    // символ, которым играет второй игрок

    public static Scanner input = new Scanner(System.in);
    public static char[][] gameField;               // игровое поле - в виде двумерного массива символов

    public static void initGameField() {
        gameField = new char[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                gameField[i][j] = EMPTY_DOT;
            }
        }
    }

    public static void printGameField() {
        for (int i = 0; i <= gameField.length; i++) {    // распечатываем горизонтальную "шапку" - координата X
            System.out.print(i == 0 ? "  " : i + " ");   // не выводим 0 на печать, а заменяем его двойным пробелом, чтобы не засорять вывод координат
        }
        System.out.println();
        for (int i = 0; i < gameField.length; i++) {
            System.out.print((i + 1) + " ");            // распечатываем вертикальную "шапку" - координата Y
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellAvailable(int x, int y) {
        return x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE && gameField[y][x] == EMPTY_DOT;    // если x и y находятся в допустимых пределах И если ячейка не равна пустой, то возвращаем true
    }

    public static void player1Move() {
        int x, y;
        do {
            System.out.printf("Введите координаты хода через пробел в формате X(= 1..%d) Y(= 1..%d):\n", FIELD_SIZE, FIELD_SIZE);
            x = Integer.valueOf(input.next()) - 1;
            y = Integer.valueOf(input.next()) - 1;
        } while (!isCellAvailable(x, y));
        gameField[y][x] = PLAYER_1_DOT;
    }

    public static void player2Move() {
        int x, y;
        do {
            x = new Random().nextInt(FIELD_SIZE);
            y = new Random().nextInt(FIELD_SIZE);
        } while (!isCellAvailable(x, y));
        System.out.println("ИИ походил в ячейку " + (x + 1) + " " + (y + 1));
        gameField[y][x] = PLAYER_2_DOT;
    }

    public static boolean isWin(char playerDot) {
        int hor, ver;
        int diagMain = 0, diagReverse = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (gameField[i][j] == playerDot) {                          // проверяем горизонтальные линии на возможную победу
                    hor++;
                } else if (gameField[i][j] != playerDot && hor < DOTS_TO_WIN) {
                    hor = 0;
                }
                if (gameField[j][i] == playerDot) {                          // проверяем вертикальные линии на возможную победу
                    ver++;
                }   else if (gameField[j][i] != playerDot && ver < DOTS_TO_WIN) {
                    ver = 0;
                }
            }
            if (hor >= DOTS_TO_WIN || ver >= DOTS_TO_WIN) {
                return true;
            }
        }

        for (int j = 0; j < FIELD_SIZE; j++) {
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = j + i;
                if (k < FIELD_SIZE) {
                    if (gameField[i][k] == playerDot) {                      // проверяем главную диагональ от центральной оси вправо на возможную победу
                        diagMain++;
                    } else if (gameField[i][k] != playerDot && diagMain < DOTS_TO_WIN) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        for (int j = 1; j < FIELD_SIZE; j++) {
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = j + i;
                if (k < FIELD_SIZE) {
                    if (gameField[k][i] == playerDot) {                      // проверяем главную диагональ от центральной оси вниз на возможную победу
                        diagMain++;
                    } else if (gameField[k][i] != playerDot && diagMain < DOTS_TO_WIN) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        for (int j = 0; j < FIELD_SIZE; j++) {
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = (FIELD_SIZE - 1) - i;
                int l = j + i;
                if (k >= 0 && l < FIELD_SIZE) {
                    if (gameField[l][k] == playerDot) {                     // проверяем побочную диагональ от центральной оси вниз на возможную победу
                        diagReverse++;
                    } else if (gameField[l][k] != playerDot && diagReverse < DOTS_TO_WIN) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        for (int j = 1; j < FIELD_SIZE; j++) {
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = (FIELD_SIZE - 1) - j - i;
                if (k >= 0) {
                    if (gameField[i][k] == playerDot) {     // проверяем побочную диагональ от центральной оси влево на возможную победу
                        diagReverse++;
                    } else if (gameField[i][k] != playerDot && diagReverse < DOTS_TO_WIN) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isDraw() {                            // метод проверяет вариант ничьей
        for (char[] aGameField : gameField) {
            for (int j = 0; j < gameField.length; j++) {
                if (aGameField[j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initGameField();                    // инициализируем игровое поле - создаём "пустой" двумерный массив
        System.out.printf("Цель игры - заполнить подряд линию по вертикали, горизонтали или диагонали из %d Ваш%s символ%s.\n", DOTS_TO_WIN, (DOTS_TO_WIN % 10 == 1 && DOTS_TO_WIN % 100 != 11) ? "его" : "их", (DOTS_TO_WIN % 10 == 1 && DOTS_TO_WIN % 100 != 11) ? "а" : "ов");
        printGameField();                   // выводим состояние начального поля в консоль
        int firstMove = new Random().nextInt(2);

        // в бесконечном цикле (повторяем, пока не найдётся либо победитель, либо ничья):
        // ход первого игрока: если человек, тогда запрашиваем координаты хода; если AI - он сам находит координаты хода
        // проверка на победу
        // проверка на ничью:
        // если всё поле заполнено, но победы не было - то ничья
        // если ничья или победа - выводим, кто победил
        // выводим на экран состояние игрового поля
        // ход второго игрока: если AI - он сам находит координаты хода; если человек, тогда запрашиваем координаты хода
        // проверка на победу
        // проверка на ничью:
        // если всё поле заполнено, но победы не было - то ничья
        // если ничья или победа - выводим, кто победил
        // выводим на экран состояние игрового поля

        switch (firstMove) {
            case 0: {
                System.out.println("Ваш ход первый!");
                while (true) {
                    player1Move();
                    printGameField();
                    if (isWin(PLAYER_1_DOT)) {
                        System.out.println("Победил Игрок 1");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                    player2Move();
                    printGameField();
                    if (isWin(PLAYER_2_DOT)) {
                        System.out.println("Победил ИИ");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                }
                break;
            }
            case 1: {
                while (true) {
                    System.out.println("Первый ход за ИИ!");
                    player2Move();
                    printGameField();
                    if (isWin(PLAYER_2_DOT)) {
                        System.out.println("Победил ИИ");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                    player1Move();
                    printGameField();
                    if (isWin(PLAYER_1_DOT)) {
                        System.out.println("Победил Игрок 1");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                }
            }
        }
    }
}
