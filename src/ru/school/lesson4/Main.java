package ru.school.lesson4;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        //1. Создать лист из своих объектов (10-15 элементов в списке). Добавить, удалить и т.д.
        System.out.println("1. ___________________________________________________________________________________");
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "318"));
        cars.add(new Car("BMW", "320"));
        cars.add(new Car("BMW", "340"));
        cars.add(new Car("Mercedes", "E200"));
        cars.add(new Car("Mercedes", "GLC320"));
        cars.add(new Car("Lada", "2101"));
        cars.add(new Car("Lada", "2104"));
        cars.add(new Car("Lada", "Vesta"));
        cars.add(new Car("Shkoda", "Oktavia"));
        cars.add(new Car("VW", "Polo"));
        cars.add(new Car("Audi", "A3"));
        //3. Вывести список элементов в читабельном виде.
        cars.forEach(System.out::println);

        cars.remove(8);

        //3. Вывести список элементов в читабельном виде.
        cars.forEach(System.out::println);


        //2. Добавить дубли в список (1 - несколько раз один и тот же объект, 2 - дубль должен быть новым объектом с теми же параметрами, что уже имеет один из существующих в списке)
        System.out.println("2, 3. ___________________________________________________________________________________");
        List<Car> cars2 = new ArrayList<>();
        Car bmw = new Car("BMW", "320");
        cars2.add(bmw);
        cars2.add(bmw);
        cars2.add(new Car("Mercedes", "E200"));
        cars2.add(new Car("Mercedes", "E200"));

        //3. Вывести список элементов в читабельном виде.
        cars2.forEach(System.out::println);
        System.out.println("4. ___________________________________________________________________________________");

        //4. Создать неповторяющееся упорядоченное множество с использованием компаратора и перенести значения из созданного листа.

        //Если я правильно понял задание
        TreeMap<String, Car> treeMap = new TreeMap<>(String::compareTo);
        cars.forEach((x) -> treeMap.put(x.getBrand(), x));
        treeMap.forEach((key4, value4) -> System.out.println(key4 + ": " + value4));

        System.out.println("___________________________________________________________________________________");

        //Если я НЕ правильно понял задание :)
        TreeMap<String, List<Car>> carTreeMap = new TreeMap<>(String::compareTo);
        cars.forEach((x) -> {
            List<Car> carList = new ArrayList<>();
            //наполняю лист всеми автомобилями по ключу
            cars.stream().filter((y) -> y.getBrand().equals(x.getBrand())).forEach(carList::add);
            carTreeMap.put(x.getBrand(), carList);
        });

        //Более читабельный вывод
        carTreeMap.forEach((key, value) -> {
            System.out.println(key + ": ");
            value.forEach(System.out::println);
        });


        //5. Обход дерева с помощью forEach и iterator (подсчет или конкатинация из объектов коллекции используя условие, например "все начинаются с буквы", "больше какого-то значения")
        //Подсчет машин через Iterator
        System.out.println("5. ___________________________________________________________________________________");
        Iterator<Map.Entry<String, List<Car>>> iterator = carTreeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Car>> entry = iterator.next();
            System.out.println("Автомобилей " + entry.getKey() + " " + entry.getValue().size());
        }

        System.out.println("___________________________________________________________________________________");

        //Подсчет машин через forEach
        carTreeMap.forEach((key3, value3) -> System.out.println("Автомобилей " + key3 + ": " + value3.size()));


        //6. Удалить третий элемент из множества.
        //Эм... ну найдём ключ третьего элемента и удалим
        System.out.println("6. ___________________________________________________________________________________");
        carTreeMap.entrySet().stream().skip(2).findFirst().ifPresent(stringListEntry -> carTreeMap.remove(stringListEntry.getKey()));
        //Выведем результат
        System.out.println("Остались только марки:");
        carTreeMap.forEach((key2, value2) -> System.out.println(key2));



        //7. Из существующей коллекции объектов создать ассоциативную карту, где ключ - объект, а значение - коллекция
        //Мне кажется это я и сделал в carTreeMap

        //8. Из существующей карты создать другую, в которой ключ остается прежним, а значение - вычисленное значение чего-либо из коллекции для ключа (по нескольким вариантам значений)
        //Тут я собираю новую мапу, заменяя лист моделей на ещё одну мапу с моделью и количеством букв в названии модели.
        System.out.println("8. ___________________________________________________________________________________");
        Map<String, Map<String, Integer>> carLenghtMap = carTreeMap
                .entrySet()
                .stream()
                .collect(Collectors.
                        toMap(Map.Entry::getKey, (y) -> y.getValue()
                                .stream()
                                .map(Car::getModel)
                                .collect(Collectors.toMap((n) -> n, String::length))));

        //Более читабельный вывод
        carLenghtMap.forEach((key1, value1) -> {
            System.out.println(key1 + ": ");
            value1.forEach((key, value) -> System.out.println("В модели: \"" + key + "\" " + value + " букв"));
        });
    }

}
