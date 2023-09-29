package edu.examples.java_classes.input.command.navigation;

import edu.examples.java_classes.input.*;
import edu.examples.java_classes.input.command.Executable;
import edu.examples.java_classes.input.command.CommandProvider;
import edu.examples.java_classes.input.command.MenuCommand;

public class ConsoleShowFindMenu extends NavigationCommand implements Executable {
    private final Menu displayMenu = Menu.SEARCH_MENU;

    @Override
    public void execute() {
        ConcreteMenu menu = super.menuSystem.getMenu(displayMenu);
        CommandProvider provider = CommandProvider.getInstance();

        menuShown = 2;

        int decision = super.makeChoice(menu);

        Executable executable = provider.getCommand(getMenuCommand(decision));
        executable.execute();

    }


    public MenuCommand getMenuCommand(int code) {
        return switch (code) {
            case 5 -> MenuCommand.FIND_BY_DATE;
            case 6 -> MenuCommand.FIND_BY_CONTENT;
            case 0 -> MenuCommand.SHOW_MAIN_MENU;
            default -> MenuCommand.NO_MENU_ACTION;
        };

    }
}
