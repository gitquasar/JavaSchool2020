package ru.school.lesson6;

import ru.school.lesson5.Box;
import ru.school.lesson5.BoxImpl;

/*
1.	Создать свой класс исключение, наследник Exception
2.	Реализовать два поля: code, description, инициализация в конструкторе
1.	code целочисленное, при создании инициализировать любое произвольное число
2.	description строка, предназначено для описания бизнес ошибки, при создании инициализировать либым значением,
3.	В конструкторе реализовать вызов родительского конструктора с аргументом message, т.е. у вас один конструктор с тремя параметрами
3.	В коде из предыдущего задания, на ваше усмотрение сдалть проверку и бросать исключение
4.	В качестве обработки исключения вывести в System.out code, description, message, после вызвать printStackTrace
5.	В одном из методов бросать unchecked исключение, например IllegalArgumentException
6.	Запустить приложение с заведомо ошибочным алгоритмом, т.е. что бы при вызове метода, который бросает ваше исключение, было брошено и обработано, после вызов метода, который генерирует unchecked исключение, запустить программу
*/
public class Main {
    public static void main(String[] args) throws Exception {
        Exception myException = new MyException(-1, "Что-то пошло не так", "Какой-то Message");
        Box<Number> numberBox = new BoxImpl<>();
        try {
            boolean result = numberBox.add(null);
            if (!result) {
                throw myException; //Правильней было бы сунуть это внутрь add, но так нагляднее
            }
        } catch (MyException ex) {
            System.out.println("Code: " + ex.code);
            System.out.println("Description: " + ex.description);
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        getUncheckedException();
    }

    private static void getUncheckedException() {
        throw new IllegalArgumentException();
    }
}
