package ru.school.lesson7;

import ru.school.lesson3.LList;
import ru.school.lesson4.Car;
import ru.school.lesson5.BoxImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Написать консольное приложение которое будет выводить в консоль всю информацию о ваших классах и полях
что нужно
- по возможности взять все классы, которые были у вас написаны до текущего задания
- создать экземпляры для каждого из них (можно скопировать из предыдущих работ так же)
- реализовать метод(ы) которые бы на вход получали некий Object и выводили в консоль абсолютно всю информацию о данном объекте используя Reflection API:
- дерево классов наследников, если есть, иначе ничего не выводить
- список реализуемых интерфейсов
- список конструкторов с параметрами
- список всех полей, в том числе приватных, включая их тип
- список всех методов
- если поле класса является не примитивным, а например любой другой произвольный класс, то по нему так же необходимо вывести всю информацию, если это коллекция то достаточно просто вывести имя коллекции и Generic, то же самое и для методов

пример
class ru.sber.pt.SomeClass
--- parents:
--- ru.sber.pt.ParentClass
--- interfaces:
---- ru.sber.pt.SomeInterface
---- fields:
---- fieldName: value java.lang.String
---- fieldNames: java.util.List<String>

 */
class Main {
    private static final String DELIMITER = "_____________________________________";
    private static List<Class<?>> classList = new ArrayList<>(); //Пройденные классы. Защита от бесконечной рекурсии.

    public static void main(String[] args) {
        LList<String> list = new LList<>();
        Car car = new Car("kia", "rio");
        BoxImpl<Integer> box = new BoxImpl<>();
        printAllInfo(list);
        printAllInfo(car);
        printAllInfo(box);
    }

    private static void printAllInfo(Class<?> clazz) {
        classList.add(clazz);
        printNameAndSimpleName(clazz); //Имя и полное имя класса
        printModifier(clazz); //Модификаторы
        printConstructorsAndParams(clazz); //Конструкторы с параметрами
        printFields(clazz); //Поля и типы
        printMethods(clazz); //Методы
        printInterfaces(clazz); //Интерфейсы
    }

    private static void printMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length > 0) {
            print("Список методов:");
            Arrays.stream(methods).forEach((x) -> print(x.getName()));
        }
    }

    private static void printFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length > 0) {
            print("Поля класса:");
            printFields(fields);
        }
    }

    private static void printFields(Field[] fields) {
        Arrays.stream(fields).forEach((x) -> {
            print(x.getType().getSimpleName() + " " + x.getName());
            if (!x.getType().isPrimitive() && !classList.contains(x.getType())) {
                printAllInfo(x.getType());
            }
        });
    }

    private static void printConstructorsAndParams(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();
        if (constructors.length > 0) {
            print("Конструкторы класса:");
            Arrays.stream(constructors).forEach((x) -> {
                print("Конструктор:" + x.getName());
                printParametersType(x);
            });
        }

    }

    private static void printParametersType(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes.length > 0) {
            print("Параметры:");
            Arrays.stream(parameterTypes).forEach((x) -> print(x.getSimpleName()));
            print("\n");
        }
    }


    private static void printAllInfo(Object o) {
        print(DELIMITER);
        classList.clear();
        try {
            Class<?> clazz = Class.forName(o.getClass().getName());
            while (clazz != null) {
                printAllInfo(clazz);
                print("\n");
                clazz = getSuperClass(clazz);
            }
        } catch (ClassNotFoundException e) {
            print("Класс не найден");
        }
        print(DELIMITER);
    }

    private static void printInterfaces(Class<?> clazz) {
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            print("Реализуемые интерфейсы: ");
            Arrays.stream(interfaces).forEach(Main::printAllInfo);
        }
    }


    private static void printNameAndSimpleName(Class<?> clazz) {
        print("Полное имя класса: " + clazz.getName());
        print("Имя класса: " + clazz.getSimpleName());
        print("\n"); //для читабельности
    }


    private static Class<?> getSuperClass(Class<?> clazz) {
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null) {
            print("Для класса " + clazz.getSimpleName() + " Суперсклассом является: " + superClass);
        }
        return superClass;
    }

    private static void printModifier(Class<?> clazz) {
        int modifiers = clazz.getModifiers();
        print("Модификаторы класса:");
        if (Modifier.isAbstract(modifiers)) {
            print("abstract");
        }
        if (Modifier.isFinal(modifiers)) {
            print("final");
        }
        if (Modifier.isInterface(modifiers)) {
            print("interface");
        }
        if (Modifier.isNative(modifiers)) {
            print("native");
        }
        if (Modifier.isPrivate(modifiers)) {
            print("private");
        }
        if (Modifier.isProtected(modifiers)) {
            print("protected");
        }
        if (Modifier.isPublic(modifiers)) {
            print("public");
        }
        if (Modifier.isStatic(modifiers)) {
            print("static");
        }
        if (Modifier.isStrict(modifiers)) {
            print("strict");
        }
        if (Modifier.isSynchronized(modifiers)) {
            print("synchronized");
        }
        if (Modifier.isTransient(modifiers)) {
            print("transient");
        }
        if (Modifier.isVolatile(modifiers)) {
            print("volatile");
        }
        print("\n"); //для читабельности
    }

    private static void print(String s) //чтоб поменьше sout писать
    {
        System.out.println(s);
    }

}


