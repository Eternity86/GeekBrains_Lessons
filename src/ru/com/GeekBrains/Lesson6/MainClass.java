package ru.com.GeekBrains.Lesson6;

public class MainClass {
    public static void main(String[] args) {
        Animal[] pets = {
                new Dog("Шарик", "белый", 2),
                new Cat("Мурзик", "рыжий", 1.5f),
                new Dog("Тузик", "серый", 1),
                new Dog("Бобик", "белый", 2.3f),
                new Dog("Рекс", "коричневый", 2),
                new Dog("Мухтар", "белый", 2),
                new Cat("Том", "рыжий", 1.3f),
                new Cat("Мурчик", "серый", 1.5f),
                new Cat("Царапка", "белый", 1.5f),
        };

        for (Animal a :
                pets) {
            System.out.println(a);
        }

        for (Animal a :
                pets) {
            if (a instanceof Dog) {
                System.out.println(a.name + " пробежал: " + a.run(456));
            }
        }

        for (Animal a :
                pets) {
            if (a instanceof Cat) {
                System.out.println(a.name + " подпрыгнул: " + a.jump(1.6f));
            }
        }

    }
}
