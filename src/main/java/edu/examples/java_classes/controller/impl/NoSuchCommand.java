package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Executable;

import java.util.logging.Level;

public class NoSuchCommand extends Command implements Executable {

	@Override
	public String execute(String request) {
		commandLog.log(Level.WARNING,"Wrong request :"+request);
		return "Error request";
	}

}
