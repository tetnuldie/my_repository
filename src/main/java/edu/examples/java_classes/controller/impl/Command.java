package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

import java.util.logging.Logger;

public abstract class Command {

    protected static final Logger commandLog = Logger.getLogger(Command.class.getName());
    protected final LogicProvider logicProvider = LogicProvider.getInstance();
    protected final NotebookLogic logic = logicProvider.getNotebookLogic();

    protected final String methodDelimiter = "\\s";
    protected final String requestDelimiter = "\\?";
    protected final String bodyDelimiter = "/";

    protected final String paramDelimiter = "=";

}
