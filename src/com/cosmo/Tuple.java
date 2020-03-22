package com.cosmo;

import java.util.Comparator;

public class Tuple<String, Double> implements Comparator {
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

    @Override
    public int compare(Object o1, Object o2) {
        double o1y = ((Tuple<String,Double>) o1).getY();
        double o2y = ((Tuple<String,Double>) o2).getY();

        if (o1y > o2y) {
            return 1;
        } else if (o1y < o2y){
            return -1;
        } else {
            return 0;
        }
    }
}
