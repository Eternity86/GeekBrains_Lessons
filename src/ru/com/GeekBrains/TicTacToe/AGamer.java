package ru.com.GeekBrains.TicTacToe;

public abstract class AGamer {
    protected String sign;

    abstract boolean shot(int x, int y);
    abstract boolean win();
}
