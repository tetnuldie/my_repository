package edu.examples.java_classes.input.command.request;

import edu.examples.java_classes.controller.Controller;
import edu.examples.java_classes.input.*;


public abstract class RequestCommand {

    protected final MenuSelectionSystem menuSystem = MenuBuilder.getInstance().getMenuSystem();
    protected final Display display = MenuBuilder.getInstance().getDisplay();
    protected final InputTerminal terminal = MenuBuilder.getInstance().getTerminal();

    protected final Controller controller = new Controller();

    protected final String methodDelimiter = "\\s";
    protected final String requestDelimiter = "\\?";
    protected final String bodyDelimiter = "/";

    protected final String paramDelimiter = "=";


    protected String inputData(ConcreteMenu m, String s) {
        String decision;

        display.printMenu(m);
        decision = terminal.strInputWithContext(s);

        return decision;
    }

}
