package edu.examples.java_classes.controller;

public class Controller {

	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request) {

		String commandName;
		Executable executionCommand;
		
		commandName = request.substring(0, request.indexOf("\\s"));
		executionCommand = provider.getCommand(commandName);
		
		String response;
		response = executionCommand.execute(request);
		
		return response;

	}

}


