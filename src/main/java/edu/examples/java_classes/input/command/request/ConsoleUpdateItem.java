package edu.examples.java_classes.input.command.request;

import edu.examples.java_classes.input.*;
import edu.examples.java_classes.input.command.CommandProvider;
import edu.examples.java_classes.input.command.Executable;
import edu.examples.java_classes.input.command.MenuCommand;

public class ConsoleUpdateItem extends RequestCommand implements Executable {
    private final MenuCommand parentMenu = MenuCommand.EDIT_NOTE_MENU;
    private final String method = "UPDATE";
    private String[] requestParams = {"id", "title", "content"};

    @Override
    public void execute() {
        ConcreteMenu menu = super.menuSystem.getMenu(Menu.CONTEXT_MENU);
        CommandProvider provider = CommandProvider.getInstance();

        String request;
        String response;

        StringBuilder sb = new StringBuilder();
        sb.append(method);
        sb.append(methodDelimiter);
        sb.append(requestDelimiter);

        for(String param : requestParams){
            request = super.inputData(menu, "Type new note " + param + " below :>" );
            sb.append(param);
            sb.append(paramDelimiter);
            sb.append(request);
            sb.append(bodyDelimiter);
        }


        System.out.println(sb);

        response = super.controller.doAction(sb.toString());
        System.out.println(response);


        Executable executable = provider.getCommand(parentMenu);
        executable.execute();
    }

}
