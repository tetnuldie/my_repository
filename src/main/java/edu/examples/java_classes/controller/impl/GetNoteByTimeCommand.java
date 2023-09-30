package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Executable;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;

import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;

public class GetNoteByTimeCommand extends Command implements Executable {
    @Override
    public String execute(String request) {
        StringBuilder response = new StringBuilder();
        String[] params;
        List<Note> newNote;

        params = request.split(paramDelimiter);

        try {
            newNote = super.logic.findByDate(params[1]);
            response.append("Processed successfully:" + "\n");
            for (Note n : newNote) {
                response.append(n.toString()).append("\n");
            }
            commandLog.log(Level.INFO,request + "\nProcessed successfully");
        } catch (LogicException e) {
            commandLog.log(Level.SEVERE, "Error on resolve items by date", e);
            response.append("Something went wrong. Try again later");
        } catch (ParseException e) {
            commandLog.log(Level.WARNING, "Error on resolve items by date", e);
            response.append("Something went wrong. Try again later");
        }

        return response.toString();
    }
}
