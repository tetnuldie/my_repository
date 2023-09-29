package edu.examples.java_classes.input.command.navigation;

import edu.examples.java_classes.input.*;
import edu.examples.java_classes.input.command.CommandProvider;
import edu.examples.java_classes.input.command.Executable;
import edu.examples.java_classes.input.command.MenuCommand;

public class ConsoleShowEditMenu extends NavigationCommand implements Executable{
    private final Menu displayMenu = Menu.EDIT_MENU;

    @Override
    public void execute() {
        ConcreteMenu menu = super.menuSystem.getMenu(displayMenu);
        CommandProvider provider = CommandProvider.getInstance();

        menuShown = 4;

        int decision = super.makeChoice(menu);

        Executable executable = provider.getCommand(getMenuCommand(decision));
        executable.execute();

    }

    public MenuCommand getMenuCommand(int code) {
        return switch (code) {
            case 7 -> MenuCommand.UPDATE_NOTE;
            case 8 -> MenuCommand.DELETE_NOTE;
            case 9 -> MenuCommand.CLEAR_ALL_NOTES;
            case 0 -> MenuCommand.SHOW_SEARCH_MENU;
            default -> MenuCommand.NO_MENU_ACTION;
        };

    }
}
