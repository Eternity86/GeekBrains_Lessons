/* ##########################################
# ДЗ к третьему уроку по Java на GeekBrains #
# ========================================= #
# Задача №3                                #
#                                           #
########################################## */

package ru.com.GeekBrains.Lesson3;

/*Создать консольный калькулятор

1 Базовый калькулятор
Введите два числа через пробел, пример
1 + 2
или
2 * 2

(должно быть доступно 4 операции + - / *)

при этом, если пользователь выбирает какое-либо другое действие, нужно об этом сказать

2 Продвинутый калькулятор

Количество элементов не ограничено
*/

import java.util.Scanner;

public class ConsoleCalculator {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        String calc = input.nextLine();
        if (calc.contains("+")) {
            String[] calcArray = calc.split(" ");
            System.out.println("Сумма чисел = " + add(calcArray));
        } else if (calc.contains("-")) {
            String[] calcArray = calc.split(" ");
            System.out.println("Разность чисел = " + sub(calcArray));
        } else if (calc.contains("*")) {
            String[] calcArray = calc.split(" ");
            System.out.println("Произведение чисел = " + mul(calcArray));
        } else if (calc.contains("/")) {
            String[] calcArray = calc.split(" ");
            System.out.println("Частное чисел = " + div(calcArray));
        } else {
            System.out.println("Такая операция не реализована");
        }
    }

    public static int add(String... arr) {
        int sum = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals("+")) {
                sum += Integer.parseInt(arr[i]);
            }
        }
        return sum;
    }
    public static int sub(String... arr) {
        int difference = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals("-")) {
                difference -= Integer.parseInt(arr[i]);
            }
        }
        return difference;
    }
    public static long mul(String... arr) {
        long product = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals("*")) {
                product *= Integer.parseInt(arr[i]);
            }
        }
        return product;
    }
    public static float div(String... arr) {
        float quotient = Float.parseFloat(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals("/")) {
                quotient /= Float.parseFloat(arr[i]);
            }
        }
        return quotient;
    }
}
