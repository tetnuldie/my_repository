package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Executable;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;

import java.util.List;
import java.util.logging.Level;

public class GetNoteCommand extends Command implements Executable {

    @Override
    public String execute(String request) {
        StringBuilder response = new StringBuilder();
        String[] params;
        List<Note> newNote;

        params = request.split(paramDelimiter);

        String[] check;
        check = params[0].split(requestDelimiter);

        if (check[1].compareTo("content") == 0) {

            if (params[1].compareTo("ALL") == 0) {
                try {
                    newNote = super.logic.getAllNotes();
                    response.append("Processed successfully:" + "\n");
                    for (Note n : newNote) {
                        response.append(n.toString()).append("\n");
                    }
                    commandLog.log(Level.INFO,request + "\nProcessed successfully");
                } catch (LogicException e) {
                    commandLog.log(Level.SEVERE,"Error on resolve all items", e);
                    response.append("Something went wrong. Try again later");
                }
            } else {

                try {
                    newNote = super.logic.find(params[1]);
                    response.append("Processed successfully:" + "\n");
                    for (Note n : newNote) {
                        response.append(n.toString()).append("\n");
                    }
                    commandLog.log(Level.INFO,request + "\nProcessed successfully");
                } catch (LogicException e) {
                    commandLog.log(Level.SEVERE,"Error on resolve items by context", e);
                    response.append("Something went wrong. Try again later");
                }
            }
        } else if (check[1].compareTo("date") == 0) {
            try {
                newNote = super.logic.findByDate(params[1]);
                response.append("Processed successfully:" + "\n");
                for (Note n : newNote) {
                    response.append(n.toString()).append("\n");
                }
                commandLog.log(Level.INFO,request + "\nProcessed successfully");
            } catch (LogicException e) {
                commandLog.log(Level.SEVERE,"Error on resolve items by date", e);
                response.append("Something went wrong. Try again later");
            }
        } else {
            response.append("Invalid request.");
            commandLog.log(Level.WARNING,"Invalid request "+request);
        }


        return response.toString();
    }
}
