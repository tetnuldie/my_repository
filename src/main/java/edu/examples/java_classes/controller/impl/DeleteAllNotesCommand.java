package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Executable;
import edu.examples.java_classes.logic.LogicException;

import java.util.logging.Level;

public class DeleteAllNotesCommand extends Command implements Executable {
    @Override
    public String execute(String request) {
        StringBuilder response = new StringBuilder();

        try {
            super.logic.delete();
            response.append("All notes Deleted successfully");
            commandLog.log(Level.INFO,request+"\nProcessed successfully");
        } catch (LogicException e) {
            commandLog.log(Level.SEVERE,"Error on delete all items", e);
            response.append("Something went wrong. Try again later");
        }
        return response.toString();
    }
}
