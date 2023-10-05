package edu.examples.java_classes.input.command.request;

import edu.examples.java_classes.input.*;
import edu.examples.java_classes.input.command.Executable;
import edu.examples.java_classes.input.command.CommandProvider;
import edu.examples.java_classes.input.command.MenuCommand;

public class ConsoleFindItemByContent extends RequestCommand implements Executable {

    private final MenuCommand parentMenu = MenuCommand.SHOW_SEARCH_MENU;
    private final String method = "GET";
    private final String requestParameter = "content";

    @Override
    public void execute() {

        ConcreteMenu menu = super.menuSystem.getMenu(Menu.CONTEXT_MENU);
        CommandProvider provider = CommandProvider.getInstance();

        String request;
        String response;

        StringBuilder sb = new StringBuilder();

        request = super.inputData(menu, "Type a string to search or ALL to return all notes :>");


        sb.append(method);
        sb.append(methodDelimiter);
        sb.append(requestDelimiter);
        sb.append(requestParameter);
        sb.append(paramDelimiter);
        sb.append(request);

        super.printString(sb.toString());

        response = super.controller.doAction(sb.toString());

        if (response.compareTo("Processed successfully:" + "\n") == 0) {
            super.printString("Nothing found");
        } else {
            super.printString(response);
        }

        Executable executable = provider.getCommand(parentMenu);
        executable.execute();

    }

}

