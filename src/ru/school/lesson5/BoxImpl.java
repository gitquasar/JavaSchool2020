package ru.school.lesson5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BoxImpl<E extends Number> implements Box<E> {
    private List<E> elementList = new ArrayList<>();

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

}
