package ru.com.GeekBrains.Lesson1;

public class MainClass {
    public static void main(String[] args) {

    // п.2
        byte b = 12;                // 1 байт - от -128 до 127
        short s = 250;              // 2 байта - от -32768 до 32767
        int i = 45000;              // 4 байта - от -2147483648 до 2147483647
        long l = 452654l;           // 8 байт - от -(2 в 64 степени) до (2 в 64 степени)-1

        float f = 1.0f;             // 4 байта
        double d = 12.3;            // 8 байт

        char c = 'c';               // 2 байта - отдельный символ в UTF-16
        char c2 = 'b';

        boolean boolTrue = true;    // true или false
        boolean boolFalse = false;


        System.out.println(getSolution(b, 6, 8, i));

        System.out.println(getSolution2Digits(5, 8));
        System.out.println(getSolution2Digits(9, 15));

        isPositiveOrNegative(-5);
        isPositiveOrNegative(5);

        System.out.println(isNegative(5));
        System.out.println(isNegative(-9));

        getGreetings("Aleksandr");
        getGreetings("Pyotr");

        isLeapYear(2005);
        isLeapYear(1980);
        isLeapYear(25);
        isLeapYear(24);
        isLeapYear(1900);



    }

    // п.3
    public static int getSolution(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    //п.4
    public static boolean getSolution2Digits(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    //п.5
    public static void isPositiveOrNegative(int a) {
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else System.out.println("Число положительное");
    }

    //п.6
    public static boolean isNegative(int a) {
        return a < 0;
    }

    //п.7
    public static void getGreetings(String s) {
        System.out.println("Привет, " + s);
    }

    //п.8
    public static void isLeapYear(int year) {
        if (year % 100 == 0 && year % 400 != 0 || year % 4 != 0) {
            System.out.println("Год невисокосный");
        } else System.out.println("Год високосный");

    }

}