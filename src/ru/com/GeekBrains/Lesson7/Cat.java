package ru.com.GeekBrains.Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private int saturationFood = 0;
    private int catFullness;
    private boolean fullness = false;

    public int getSaturationFood() {
        return saturationFood;
    }

    public int getCatFullness() {
        return catFullness;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullness() {
        return fullness;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.catFullness = this.appetite * 4;
    }

    public void eat(Plate p) {
        if (!this.fullness) {
            if (p.decreaseFood(this.appetite)) {
                System.out.printf("%s съел %d единиц еды\n", this.name, this.appetite);
                this.saturationFood += this.appetite;
                if (this.saturationFood >= this.catFullness) {
                    //System.out.printf("%s наелся\n", this.name);
                    this.fullness = true;
                }
            } else {
                System.out.printf("%s не смог съесть %d единиц еды\n", this.name, this.appetite);
            }
        }
    }
}
