package ru.school.lesson5;


public interface Box<E extends Number> {
    boolean add(E element);

    E get(int elementId);

    void sort();

    E max();

    void print();

}
