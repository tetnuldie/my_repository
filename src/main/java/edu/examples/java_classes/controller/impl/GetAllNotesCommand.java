package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Executable;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;

import java.util.List;
import java.util.logging.Level;

public class GetAllNotesCommand extends Command implements Executable {
    @Override
    public String execute(String request) {
        StringBuilder response = new StringBuilder();
        List<Note> newNote;

        try {
            newNote = super.logic.getAllNotes();
            response.append("Processed successfully:" + "\n");
            for (Note n : newNote) {
                response.append(n.toString()).append("\n");
            }
            commandLog.log(Level.INFO, request + "\nProcessed successfully");
        } catch (LogicException e) {
            commandLog.log(Level.SEVERE, "Error on resolve all items", e);
            response.append("Something went wrong. Try again later");
        }

        return response.toString();

    }
}
