package ru.school.lesson2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeImpl implements Command {
    private static final String COMMAND_NAME = "time";

    @Override
    public String getName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
