package com.zy;

public class Mount_Qomolangma {
    public static void main(String[] args) {
        double mount = 884886;
        double paper = 1.0;
        int count = 0;
        while (paper < mount) {
            paper *= 2;
            count ++;
        }
        System.out.println(count);
    }
}
