package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static float a = 0;
    static float b = 0;


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        char[] digits = line.toCharArray();
        String[] lst = {""};
        int operation = 0;
        for (char o : digits) {
            if (o == '+') {
                lst = line.split(Pattern.quote("+"));
                SetAB(lst);
                operation = 0;
            }
            if (o == '-') {
                lst = line.split(Pattern.quote("-"));
                SetAB(lst);
                operation = 1;
            }
            if (o == '*') {
                lst = line.split(Pattern.quote("*"));
                SetAB(lst);
                operation = 2;
            }
            if (o == '/') {
                lst = line.split(Pattern.quote("/"));
                SetAB(lst);
                operation = 3;
            }
        }

        float result = 0;

        switch (operation) {
            case 0:
                result = a + b;
                ;
                break;
            case 1:
                result = a - b
                ;
                break;
            case 2:
                result = a * b;
                ;
                break;
            case 3:
                result = a / b;
                ;
                break;
        }
        System.out.println(result);
    }

    static void SetAB(String[] lst) {
        if (isNumeric(lst[0]) && isNumeric(lst[1])) {
            a = Float.valueOf(lst[0]);
            b = Float.valueOf(lst[1]);
        } else {
            a = ToArabic(lst[0]);
            b = ToArabic(lst[1]);
        }
    }

    public static int ToArabic(String str) {
        int result = 0;
        int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String test = str;

        for (int i = 0; i < decimal.length; i++) {
            while (test.indexOf(roman[i]) == 0) {
                result += decimal[i];
                test = test.substring(roman[i].length());
            }
        }

        return result;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
