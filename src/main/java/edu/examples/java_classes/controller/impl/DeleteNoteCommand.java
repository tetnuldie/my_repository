package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Executable;
import edu.examples.java_classes.logic.LogicException;

import java.util.logging.Level;

public class DeleteNoteCommand extends Command implements Executable {

    @Override
    public String execute(String request) {
        StringBuilder response = new StringBuilder();

        if (request.contains(methodDelimiter) && request.contains(requestDelimiter)) {
            try {
                super.logic.deleteNote(Integer.parseInt(request.split(paramDelimiter)[1]));
                response.append("Deleted successfully");
                commandLog.log(Level.INFO,request+"\nProcessed successfully");
            } catch (LogicException e) {
                commandLog.log(Level.SEVERE,"Error on delete item by id", e);
                response.append("Something went wrong. Try again later");
            }
        } else if (request.contains(methodDelimiter) && !request.contains(requestDelimiter)) {
            try {
                super.logic.delete();
                response.append("All notes Deleted successfully");
                commandLog.log(Level.INFO,request+"\nProcessed successfully");
            } catch (LogicException e) {
                commandLog.log(Level.SEVERE,"Error on delete all items", e);
                response.append("Something went wrong. Try again later");
            }

        } else {
            response.append("Invalid request.");
            commandLog.log(Level.WARNING,"Invalid request "+request);
        }

        return response.toString();
    }
}
