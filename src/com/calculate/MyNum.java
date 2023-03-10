package com.calculate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum MyNum {
    NULL(0), I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XL(40), L(50), XC(90), C(100);
    private final int value;

    MyNum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<MyNum> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((MyNum e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
}