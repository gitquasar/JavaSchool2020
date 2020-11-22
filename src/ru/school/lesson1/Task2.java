package ru.school.lesson1;

public class Task2 {

    public static void main(String[] args) {
        division(21, 8);
    }

    private static void division(int a, int b) {
        System.out.printf("a / b = %d и %d в остатке", a / b, a % b);
        System.out.println();
    }

}
