package ru.school.lesson2;

public class ExitImpl implements Command {
    private static final String COMMAND_NAME = "exit";
    @Override
    public String getName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
