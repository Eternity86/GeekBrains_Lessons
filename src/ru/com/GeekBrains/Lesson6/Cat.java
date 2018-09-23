package ru.com.GeekBrains.Lesson6;

import java.util.Random;

public class Cat extends Animal {
    private final float RUN_DISTANCE = 200.0f;
    private final float SWIM_DISTANCE = 0.0f;
    private final float JUMP_HEIGHT = 2.0f;
    private float runDistance;
    private float swimDistance;
    private float jumpHeight;

    public Cat(String name, String color, float age) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.runDistance = new Random().nextInt(2) == 1 ? RUN_DISTANCE + new Random().nextInt(51) : RUN_DISTANCE - new Random().nextInt(51); //ограничение на бег 200±50 м
        this.swimDistance = SWIM_DISTANCE; //не проплывёт и метра
        this.jumpHeight = new Random().nextInt(2) == 1 ? JUMP_HEIGHT + new Random().nextFloat() / 2 : JUMP_HEIGHT - new Random().nextFloat() / 2; //ограничение на прыжок 2±0,45 м
    }

    public float getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(float runDistance) {
        this.runDistance = runDistance;
    }

    public float getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public float getSwimDistance() {
        return swimDistance;
    }

    /*public void setSwimDistance(float swimDistance) {
        this.swimDistance = swimDistance;
    }*/

    @Override
    public String toString() {
        return "Кот {" +
                "кличка = '" + this.name + '\'' +
                ", окрас = '" + this.color + '\'' +
                ", возраст = " + this.age + " лет" +
                ", может пробежать " + this.runDistance + " м" +
                ", не может плавать" +
                ", может подпрыгнуть на " + String.format("%.2f", this.jumpHeight) + " м" +
                '}';
    }

    @Override
    public boolean swim(float distance) {
        return false;
    }

    @Override
    public boolean run(float distance) {
        return !(distance > this.runDistance);
    }

    @Override
    public boolean jump(float height) {
        return !(height > this.jumpHeight);
    }
}
