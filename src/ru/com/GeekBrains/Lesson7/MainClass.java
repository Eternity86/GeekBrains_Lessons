package ru.com.GeekBrains.Lesson7;

public class MainClass {
    public static void main(String[] args) {
        Cat[] pets = {
                new Cat("Barsik", 9),
                new Cat("Murzik", 7),
                new Cat("Markiz", 5),
                new Cat("Tom", 1),
                new Cat("Pushok", 3),
                new Cat("Snezhok", 1)
        };
        Plate plate = new Plate(61);
        plate.info();

        for (Cat c : pets) {
            while (!c.isFullness() && Plate.getFood() >= c.getAppetite()) {
                c.eat(plate);
                plate.info();
            }

        }
        for (Cat c : pets) {
            if (!c.isFullness()) {
                System.out.printf("%s остался голодным, ему не хватило %d единиц еды\n", c.getName(), c.getCatFullness() - c.getSaturationFood());
            } else {
                System.out.printf("%s наелся\n", c.getName());
            }
        }
    }
}
