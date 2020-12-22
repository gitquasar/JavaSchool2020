package ru.school.lesson5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BoxImpl<E extends Number> implements Box<E> {
    private List<E> elementList = new ArrayList<>();
    private Comparator<E> elementComparator = (e, t1) -> {
        if (e.longValue() == t1.longValue()) {
            return 0;
        } else {
            return e.longValue() < t1.longValue() ? -1 : 1;
        }
    };

    public boolean add(E element) {
        if (element != null) {
            elementList.add(element);
            return true;
        }
        return false;
    }

    public E get(int elementId) {
        return elementList.get(elementId);
    }

    @Override
    public void sort() {
        elementList.sort(elementComparator);
    }

    @Override
    public E max() {
        return elementList.stream().max(elementComparator).orElse(null);
    }

    public void print() {
        elementList.forEach(System.out::println);
    }

}
