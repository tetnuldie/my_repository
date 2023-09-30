package edu.examples.java_classes.input.command.request;

import edu.examples.java_classes.input.ConcreteMenu;
import edu.examples.java_classes.input.Menu;
import edu.examples.java_classes.input.command.CommandProvider;
import edu.examples.java_classes.input.command.Executable;
import edu.examples.java_classes.input.command.MenuCommand;

public class ConsoleGetAllNotes extends RequestCommand implements Executable{
    private final MenuCommand parentMenu = MenuCommand.SHOW_SEARCH_MENU;
    private final String method = "GET_ALL";

    @Override
    public void execute() {

        CommandProvider provider = CommandProvider.getInstance();

        String response;

        StringBuilder sb = new StringBuilder();

        sb.append(method);
        sb.append(methodDelimiter);
        sb.append(requestDelimiter);

        System.out.println(sb);

        response = super.controller.doAction(sb.toString());

        if (response.compareTo("Processed successfully:" + "\n") == 0) {
            System.out.println("Nothing found");
        } else {
            System.out.println(response);
        }

        Executable executable = provider.getCommand(parentMenu);
        executable.execute();

    }
}
