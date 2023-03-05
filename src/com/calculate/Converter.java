package com.calculate;

import java.util.List;

public class Converter {
    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 100)) {
            throw new IllegalArgumentException(number + " is not in range (0,100]");
        }

        List<MyNum> MyNums = MyNum.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < MyNums.size())) {
            MyNum currentSymbol = MyNums.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}