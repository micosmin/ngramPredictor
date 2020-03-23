package com.cosmo;

public class Tuple<A, B> {
    private final A x;
    private final B y;

    public Tuple(A x, B y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public java.lang.String toString() {
        return x + "," + y;
    }

    public B getY() {
        return y;
    }
}
