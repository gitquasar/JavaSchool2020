package ru.school.lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Command[] commands = {new DateImpl(), new ExitImpl(), new TimeImpl()};
        while (in.hasNext())
        {
            boolean executed = false;
            String some = in.nextLine();
            for (Command cmd: commands) {
                if(cmd.getName().equalsIgnoreCase(some))
                {
                    cmd.execute();
                    executed = true;
                }
            }
            if (!executed)
            {
                System.out.println("\"" + some + "\" не является внутренней командой");
            }
        }

/**
 * Если будет время, то хотелось бы услышать комментарии по такому подходу:
  */
//        while (in.hasNext())
//        {
//            String some = in.nextLine();
//            Optional<Command> optional = Arrays.stream(commands).filter(x -> x.getName().equalsIgnoreCase(some)).findFirst();
//            if(!optional.isPresent())
//            {
//                System.out.println("\"" + some + "\" не является внутренней командой");
//                continue;
//            }
//            optional.get().execute();
//
//        }


    }
}
