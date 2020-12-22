package ru.school.lesson5;

/*
1. Создать методы , которые будут принимать обобщенные параметры. Использовать extends и super.
2. Создать интерфейс или класс с обобщенным(и) типом(типами).
3. Добавить методы в интерфейс. Например, max, sort и т.д.
4. Создать реализации интерфейса.
5. Для коллекций из предыдущего урока создать обобщенные реализации для вычислений, finders.
*/
public class Main {
    public static void main(String[] args) {
        Box<Number> numberBox = new BoxImpl<>();
        numberBox.add(1);
        numberBox.add(2);
        numberBox.add(3);
        Number num = 5;
        numberBox.add(num);

        System.out.println(numberBox.get(3));

    }
}
