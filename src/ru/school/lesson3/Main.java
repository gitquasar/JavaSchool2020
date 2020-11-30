package ru.school.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LList<String> list1 = new LList<>();
        list1.add("Test string");
        list1.add("Test2 string");
        list1.add("Test3 string");
        System.out.println(list1.get(2));

        LList<Integer> list2 = new LList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println(list2.get(0));


    }
}
