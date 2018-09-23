package ru.com.GeekBrains.Lesson6;

import java.util.Random;

public class Dog extends Animal {
    private final float RUN_DISTANCE = 500.0f;
    private final float SWIM_DISTANCE = 10.0f;
    private final float JUMP_HEIGHT = 0.5f;
    private float runDistance;
    private float swimDistance;
    private float jumpHeight;

    public Dog(String name, String color, float age) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.runDistance = new Random().nextInt(2) == 1 ? RUN_DISTANCE + new Random().nextInt(101) : RUN_DISTANCE - new Random().nextInt(101); //ограничение на бег 500±100 м
        this.swimDistance = new Random().nextInt(2) == 1 ? SWIM_DISTANCE + new Random().nextInt(3) : SWIM_DISTANCE - new Random().nextInt(3); //ограничение на плавание 10±2 м
        this.jumpHeight = new Random().nextInt(2) == 1 ? JUMP_HEIGHT + new Random().nextFloat() / 10 : JUMP_HEIGHT - new Random().nextFloat() / 10; //ограничение на прыжок 0,5±0,09 м
    }

    @Override
    public String toString() {
        return "Собака {" +
                "кличка = '" + this.name + '\'' +
                ", окрас = '" + this.color + '\'' +
                ", возраст = " + this.age + " лет" +
                ", может пробежать " + this.runDistance + " м" +
                ", может проплыть " + this.swimDistance + " м" +
                ", может подпрыгнуть на " + String.format("%.2f", this.jumpHeight) + " м" +
               '}';
    }

    @Override
    public boolean run(float distance) {
        return !(distance > this.runDistance);
    }

    @Override
    public boolean swim(float distance) {
        return !(distance > this.swimDistance);
    }

    @Override
    public boolean jump(float height) {
        return !(height > this.jumpHeight);
    }


}

