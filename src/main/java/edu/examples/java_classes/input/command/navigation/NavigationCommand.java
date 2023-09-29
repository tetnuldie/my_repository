package edu.examples.java_classes.input.command.navigation;

import edu.examples.java_classes.input.*;

public abstract class NavigationCommand {

    protected final MenuSelectionSystem menuSystem = MenuBuilder.getInstance().getMenuSystem();
    protected final Display display = MenuBuilder.getInstance().getDisplay();
    protected final InputTerminal terminal = MenuBuilder.getInstance().getTerminal();

    protected static int menuShown;

    protected int makeChoice(ConcreteMenu m) {
        int decision;

        display.printMenu(m);
        decision = terminal.input();

        return decision;
    }
}
