package ru.school.lesson2;

import java.time.LocalDateTime;

public class DateImpl implements Command {
    private static final String COMMAND_NAME = "date";
    @Override
    public String getName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toLocalDate().toString());
    }
}
