package ru.netology.service;

public class CustomsService {

    public static final int CUSTOMS_WEIGHT_RATE = 100;

    public static int calculateCustoms(int price, int weight) {
        return (int) (price * 0.01 + weight * CUSTOMS_WEIGHT_RATE);
    }
}
