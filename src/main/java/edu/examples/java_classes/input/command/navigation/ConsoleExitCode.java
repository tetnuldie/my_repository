package edu.examples.java_classes.input.command.navigation;

import edu.examples.java_classes.input.command.Executable;

public class ConsoleExitCode implements Executable {

    @Override
    public void execute() {
        System.out.println("App closed. Bye Bye");
    }

}
