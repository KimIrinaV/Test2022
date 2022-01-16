package com.KimIrinaV;

import java.util.Scanner;

public class Main {

    public static int linearSearch(String[] array, String elementToSearch) {
        for (int i = 0; i < array.length; i++) {
            //System.out.println("array[i]=" + array[i] + "; elementToSearch=" + elementToSearch);
            if (array[i].equalsIgnoreCase(elementToSearch)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a=0,b=0;
        int x=0;
        boolean isRim = false;
        String[] operators = {};
        String [] RimNum = {"N","I","II","III","IV","V","VI","VII","VIII","IX","X",
                "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
                "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
                "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
                "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
                "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
                "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
                "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
                "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
                "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};

        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        String arithmeticOperation = in.nextLine();
        operators = arithmeticOperation.split(" ");

        a = linearSearch(RimNum,operators[0]) ;
        try {
            b = linearSearch(RimNum,operators[2]) ;
        } catch (ArrayIndexOutOfBoundsException  e) {
            System.err.println("Операторы не разделены пробелом!");
            System.exit(0);
        }

        if ((a!=-1)&&(b!=-1)) isRim = true;

        if (!isRim) {
            try {
                a = Byte.valueOf(operators[0]);
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат строки!");
                System.exit(0);
            }

            try {
                b = Byte.valueOf(operators[2]);
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат строки!");
                System.exit(0);
            }
        }
        if ((a>0)&&(a<11)) {
            if ((b > 0) && (b < 11)) {
                switch ( operators[1]){
                    case "+":  x = a + b; break;
                    case "-":  x = a - b; break;
                    case "*":  x = a * b; break;
                    case "/":  x = (int) (a / b); break;
                    default: System.err.println("Обработка только арифметических операций: +,-,*,/");
                }
                //System.out.println("X="+x);
                if (isRim) {
                    if (x>0)System.out.println("Output:  "+RimNum[x]);
                    else System.out.println("Output:  -"+RimNum[-x]);
                }
                else   System.out.printf("Output:  %d \n ",x);
            } else System.err.println("b must be from 1 to 10");
        } else System.err.println("a must be from 1 to 10");
        in.close();
    }
}

