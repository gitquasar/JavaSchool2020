package ru.school.lesson1;

import java.math.BigInteger;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        fibonacchi();
    }

    private static void fibonacchi() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Использую не long, потому что фибоначчи 99 уже не влезает в long.
        BigInteger x = new BigInteger("1");
        BigInteger y = new BigInteger("1");
        BigInteger res = new BigInteger("0");
        if (n > 2 && n < 100) {
            System.out.printf("%d %d ", x, y);
            for (int i = 2; i < n; i++) {
                res = x.add(y);
                System.out.printf("%d ", res);
                x = y;
                y = res;
            }
        }
        System.out.println();
    }
}
