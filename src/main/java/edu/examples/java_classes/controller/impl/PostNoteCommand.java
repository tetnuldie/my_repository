package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Executable;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;

import java.util.logging.Level;

public class PostNoteCommand extends Command implements Executable {

	@Override
	public String execute(String request) {
		String response;
		String[] params;

		params = request.split(bodyDelimiter);

		try {
			super.logic.add(params[0].split(paramDelimiter)[1],params[1].split(paramDelimiter)[1]);
			response = "Saved successfully";
			commandLog.log(Level.INFO, request+"\nProcessed successfully");
		} catch (LogicException e) {
			commandLog.log(Level.SEVERE,"Error on add new item ", e);
			response = "Logic exception: Something went wrong. Try again later";
		}

		return response;
	}

}
