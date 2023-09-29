package edu.examples.java_classes.input.command.request;

import edu.examples.java_classes.input.*;
import edu.examples.java_classes.input.command.CommandProvider;
import edu.examples.java_classes.input.command.Executable;
import edu.examples.java_classes.input.command.MenuCommand;

public class ConsoleDeleteNote extends RequestCommand implements Executable {

    private final MenuCommand parentMenu = MenuCommand.EDIT_NOTE_MENU;
    private final String method = "DELETE";
    private final String requestParameter = "id";

    @Override
    public void execute() {
        ConcreteMenu menu = super.menuSystem.getMenu(Menu.CONTEXT_MENU);
        CommandProvider provider = CommandProvider.getInstance();

        String request;
        String response;

        StringBuilder sb = new StringBuilder();

        request = super.inputData(menu, "Type note " + requestParameter + " to delete below :>");

        sb.append(method);
        sb.append(methodDelimiter);
        sb.append(requestDelimiter);
        sb.append(requestParameter);
        sb.append(paramDelimiter);
        sb.append(request);

        System.out.println(sb);

        response = super.controller.doAction(sb.toString());
        System.out.println(response);


        Executable executable = provider.getCommand(parentMenu);
        executable.execute();

    }

}
