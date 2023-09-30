package edu.examples.java_classes.input.command.navigation;

import edu.examples.java_classes.input.command.Executable;
import edu.examples.java_classes.input.command.CommandProvider;
import edu.examples.java_classes.input.command.MenuCommand;

public class ConsoleNoAction extends NavigationCommand implements Executable {


    @Override
    public void execute() {
        System.out.println("Wrong choice, Once again:");
        CommandProvider provider = CommandProvider.getInstance();

        Executable executable = provider.getCommand(getMenuCommand(menuShown));
        executable.execute();

    }

    public MenuCommand getMenuCommand(int code) {
        return switch (code) {
            case 1 -> MenuCommand.SHOW_SEARCH_MENU;
            case 3 -> MenuCommand.EDIT_NOTE_MENU;
            default -> MenuCommand.SHOW_MAIN_MENU;
        };

    }
}
