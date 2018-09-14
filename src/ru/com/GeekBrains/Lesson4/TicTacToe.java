package ru.com.GeekBrains.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final int FIELD_SIZE = 3;    // размер игрового поля
    public static final int DOTS_TO_WIN = 3;        // сколько ячеек нужно подряд заполнить, чтобы победить

    public static final char EMPTY_DOT = '.';       // заполнитель для пустой ячейки
    public static final char PLAYER_1_DOT = 'X';    // символ, которым играет первый игрок
    public static final char PLAYER_2_DOT = 'O';    // символ, которым играет второй игрок

    public static Scanner input = new Scanner(System.in);
    public static char[][] gameField;               // игровое поле - в виде двумерного символьного массива

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
            System.out.print(i == 0 ? "  " : i + " ");  // не выводим 0 на печать, а заменяем его двойным пробелом, чтобы не засорять вывод координат
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
        return x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE && gameField[y][x] == EMPTY_DOT;
    }

    public static void player1Move() {
        int x, y;
        do {
            System.out.printf("Введите координаты хода в формате X(= 1..%d) Y(= 1..%d):\n", FIELD_SIZE, FIELD_SIZE);
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
        System.out.println("ИИ походил в точку " + (x + 1) + " " + (y + 1));
        gameField[y][x] = PLAYER_2_DOT;
    }

    public static boolean isWin(char playerSymbol) {
        int hor, ver;
        for (int i = 0; i < FIELD_SIZE; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (gameField[i][j] == playerSymbol) {      // проверяем горизонтальные линии на возможную победу
                    hor++;
                }
                if (gameField[j][i] == playerSymbol) {      // проверяем вертикальные линии на возможную победу
                    ver++;
                }
            }
            if (hor == DOTS_TO_WIN || ver == DOTS_TO_WIN) {
                return true;
            }
        }
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (gameField[i][i] == playerSymbol) {                      // проверяем главную диагональ на возможную победу
                diag1++;
            }
            if (gameField[i][FIELD_SIZE - i - 1] == playerSymbol) {     // проверяем побочную диагональ на возможную победу
                diag2++;
            }
        }
        if (diag1 == DOTS_TO_WIN || diag2 == DOTS_TO_WIN) {
            return true;
        }

        return false;

        /*if(gameField[0][0] == playerSymbol && gameField[0][1] == playerSymbol && gameField[0][2] == playerSymbol) return true;
        if(gameField[1][0] == playerSymbol && gameField[1][1] == playerSymbol && gameField[1][2] == playerSymbol) return true;
        if(gameField[2][0] == playerSymbol && gameField[2][1] == playerSymbol && gameField[2][2] == playerSymbol) return true;

        if(gameField[0][0] == playerSymbol && gameField[1][0] == playerSymbol && gameField[2][0] == playerSymbol) return true;
        if(gameField[0][1] == playerSymbol && gameField[1][1] == playerSymbol && gameField[2][1] == playerSymbol) return true;
        if(gameField[0][2] == playerSymbol && gameField[1][2] == playerSymbol && gameField[2][2] == playerSymbol) return true;

        if(gameField[0][0] == playerSymbol && gameField[1][1] == playerSymbol && gameField[2][2] == playerSymbol) return true;
        if(gameField[2][0] == playerSymbol && gameField[1][1] == playerSymbol && gameField[0][2] == playerSymbol) return true;
        return false;*/
    }

    public static boolean isDraw() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (gameField[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initGameField();
        printGameField();
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
    }


    // в цикле:
    // ход первого игрока: если человек, тогда запрашиваем координаты хода; если AI - он сам находит координаты хода
    // проверка на ничью:
    // если всё поле заполнено, но победы не было - то ничья
    // проверка на победу
    // если ничья или победа - выводим, кто победил
    // выводим на экран состояние игрового поля
    // ход второго игрока: если AI - он сам находит координаты хода; если человек, тогда запрашиваем координаты хода
    // проверка на ничью:
    // если всё поле заполнено, но победы не было - то ничья
    // проверка на победу
    // если ничья или победа - выводим, кто победил
    // выводим на экран состояние игрового поля


}
