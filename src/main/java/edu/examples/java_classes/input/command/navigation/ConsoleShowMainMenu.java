package edu.examples.java_classes.input.command.navigation;

import edu.examples.java_classes.input.*;
import edu.examples.java_classes.input.command.Executable;
import edu.examples.java_classes.input.command.CommandProvider;
import edu.examples.java_classes.input.command.MenuCommand;

public class ConsoleShowMainMenu extends NavigationCommand implements Executable {
    private final Menu displayMenu = Menu.MAIN_MENU;

    @Override
    public void execute() {
        ConcreteMenu menu = super.menuSystem.getMenu(displayMenu);
        CommandProvider provider = CommandProvider.getInstance();

        menuShown = 99;

        int decision = super.makeChoice(menu);

        Executable executable = provider.getCommand(getMenuCommand(decision));
        executable.execute();

    }


    public MenuCommand getMenuCommand(int code) {
        return switch (code) {
            case 1 -> MenuCommand.SHOW_SEARCH_MENU;
            case 2 -> MenuCommand.CREATE_NEW_ITEM;
            case 3 -> MenuCommand.EDIT_NOTE_MENU;
            case 0 -> MenuCommand.EXIT_CODE;
            default -> MenuCommand.NO_MENU_ACTION;
        };
    }
}
