package ru.com.GeekBrains.Lesson1;

public class MainClass {
    public static void main(String[] args) {

    // п.2
        byte b = 12;                // 1 ���� - �� -128 �� 127
        short s = 250;              // 2 ����� - �� -32768 �� 32767
        int i = 45000;              // 4 ����� - �� -2147483648 �� 2147483647
        long l = 452654l;           // 8 ���� - �� -(2 � 64 �������) �� (2 � 64 �������)-1

        float f = 1.0f;             // 4 �����
        double d = 12.3;            // 8 ����

        char c = 'c';               // 2 ����� - ��������� ������ � UTF-16
        char c2 = 'b';

        boolean boolTrue = true;    // true ��� false
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
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else return false;
    }

    //п.5
    public static void isPositiveOrNegative(int a) {
        if (a < 0) {
            System.out.println("����� �������������");
        } else System.out.println("����� �������������");
    }

    //п.6
    public static boolean isNegative(int a) {
        if (a < 0) {
            return true;
        } else return false;
    }

    //п.7
    public static void getGreetings(String s) {
        System.out.println("Привет, " + s);
    }

    //п.8
    public static void isLeapYear(int year) {
        if (year % 100 == 0 && year % 400 != 0 || year % 4 != 0) {
            System.out.println("��� ������������");
        } else System.out.println("��� ����������");

    }

}