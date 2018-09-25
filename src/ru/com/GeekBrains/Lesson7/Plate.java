package ru.com.GeekBrains.Lesson7;

public class Plate {
    private static int food;

    public Plate(int n) {
        food = n < 0 ? -n : n;
        info();
    }

    public static int getFood() {
        return food;
    }

    boolean decreaseFood(int n) {
        if (n > food) {
            return false;
        } else {
            food -= n;
            return true;
        }
    }

    void addFood(int n) {
        food += n < 0 ? -n : n;
    }

    public void info() {
        System.out.printf("В тарелке %d единиц еды\n\n", food);
    }
}
