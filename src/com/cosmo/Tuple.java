package com.cosmo;

import java.util.Comparator;

public class Tuple<String, Double> {
    private final String x;
    private final double y;

    public Tuple(String x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public java.lang.String toString() {
        return x + "," + y;
    }

    public double getY() {
        return y;
    }
}
