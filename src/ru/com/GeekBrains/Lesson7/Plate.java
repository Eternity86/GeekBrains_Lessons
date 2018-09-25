package ru.com.GeekBrains.Lesson7;

public class Plate {
    private static int food;

    public static int getFood() {
        return food;
    }

    public Plate(int food) {
        Plate.food = food < 0 ? -food : food;
    }

    boolean decreaseFood(int n) {
        if (n > Plate.food) {
            return false;
        }else {
            Plate.food -= n;
            return true;
        }
    }

    void addFood(int n) {
        Plate.food += n;
    }

    public void info() {
        System.out.printf("В тарелке %d единиц еды\n\n", Plate.food);
    }
}
