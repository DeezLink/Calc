package com.calculate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.println("Input: ");
            String line = scanner.nextLine();
            line = line.trim();

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Неверный ввод");

                Integer a = getNameNumberEnum(symbols[0]);
                Integer b = getNameNumberEnum(symbols[2]);
                Integer intA = getValueNumberEnum(symbols[0]);
                Integer intB = getValueNumberEnum(symbols[2]);

                if (a != null && b != null) {
                    result = calculate(a, b, symbols[1]);
                    int resultInt = Integer.parseInt(result);
                    if (resultInt <= 0) {
                        throw new Exception("В римской системе нет отрицательных чисел");
                    }
                    result = Converter.arabicToRoman(resultInt);

                } else if (intA != null && intB != null) {
                    result = calculate(intA, intB, symbols[1]);
                } else throw new Exception("Неверный ввод операндов");
                System.out.println("Output: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        scanner.close();
    }

    public static Integer getNameNumberEnum(String s) {
        MyNum[] str = MyNum.values();
        for (MyNum a : str) {
            if (a.name().equals(s)) {
                return a.getValue();
            }
        }
        return null;
    }

    public static Integer getValueNumberEnum(String s) {
        try {
            MyNum[] str = MyNum.values();
            for (MyNum a : str) {
                if (a.getValue() == Integer.parseInt(s)) {
                    return a.getValue();
                } else if (0 == Integer.parseInt(s)) {
                    return 0;
                }
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return null;
    }

    public static String calculate(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                return String.valueOf(a / b);
            default:
                throw new Exception("Формат математической операции не удовлетворяет заданию");
        }
    }
}