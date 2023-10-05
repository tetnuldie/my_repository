package edu.examples.java_classes.input.command.request;

import edu.examples.java_classes.input.*;
import edu.examples.java_classes.input.command.CommandProvider;
import edu.examples.java_classes.input.command.Executable;
import edu.examples.java_classes.input.command.MenuCommand;

public class ConsoleDeleteAll extends RequestCommand implements Executable {
    private final MenuCommand parentMenu = MenuCommand.EDIT_NOTE_MENU;
    private final String method = "DELETE_ALL";

    @Override
    public void execute() {
        ConcreteMenu menu = super.menuSystem.getMenu(Menu.CONTEXT_MENU);
        CommandProvider provider = CommandProvider.getInstance();

        String request;
        String response;

        StringBuilder sb = new StringBuilder();

        request = super.inputData(menu, "Are You Really want to delete all items? Y/N?");

        if (request.compareTo("Y") == 0) {
            sb.append(method);
            sb.append(methodDelimiter);

            super.printString(sb.toString());

            response = super.controller.doAction(sb.toString());
            super.printString(response);


        }
        Executable executable = provider.getCommand(parentMenu);
        executable.execute();
    }

}
