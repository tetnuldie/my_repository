package edu.examples.java_classes.controller.impl;

import java.util.Date;
import java.util.logging.Level;

import edu.examples.java_classes.controller.Executable;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;

public class UpdateNoteCommand extends Command implements Executable {

	@Override
	public String execute(String request) {
		String response;
		String[] params;

		params = request.split(bodyDelimiter);


		try {
			super.logic.updateNote(Integer.parseInt(params[0].split(paramDelimiter)[1]),
					params[1].split(paramDelimiter)[1],
					params[2].split(paramDelimiter)[1]);
			response = "Processed successfully";
			commandLog.log(Level.INFO, request+"\nProcessed successfully");
		} catch(LogicException e) {
			commandLog.log(Level.SEVERE,"Error on edit existing item ", e);
			response = "Logic exception: Something went wrong. Try again later";
		}
		
		return response;
	}

}
