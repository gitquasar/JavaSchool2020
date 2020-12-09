package ru.school.lesson6;

public class MyException extends Exception {
    int code;
    String description;

    public MyException(int code, String description, String message) {
        super(message);
        this.code = code;
        this.description = description;
    }
}
