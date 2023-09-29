package edu.examples.java_classes.controller;

import java.util.HashMap;
import java.util.Map;

import edu.examples.java_classes.controller.impl.*;

public class CommandProvider {
	private final Map<CommandName, Executable> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.GET, new GetNoteCommand());
		repository.put(CommandName.POST, new PostNoteCommand());
		repository.put(CommandName.UPDATE, new UpdateNoteCommand());
		repository.put(CommandName.DELETE, new DeleteNoteCommand());
		repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
	}
	
	Executable getCommand(String name){
		CommandName commandName;
		Executable command;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e){
			//write log
			command = repository.get(CommandName.WRONG_REQUEST);
		}				
		return command;
	}

}
