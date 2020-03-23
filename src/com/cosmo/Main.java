package com.cosmo;


public class Main {

    public static void main(String[] args) {
        String result = NgramPredict.predict(2, "to");
        System.out.println(result);
    }


}
