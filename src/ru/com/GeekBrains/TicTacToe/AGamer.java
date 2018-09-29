package ru.com.GeekBrains.Lesson8.TicTacToe_Swing;

public abstract class AGamer {
    protected String sign;

    abstract boolean shot(int x, int y);
    abstract boolean win();
}
