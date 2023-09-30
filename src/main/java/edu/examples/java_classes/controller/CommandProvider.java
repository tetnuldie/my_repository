package edu.examples.java_classes.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.examples.java_classes.controller.impl.*;

public class CommandProvider {
	private final Map<CommandName, Executable> repository = new HashMap<>();
	protected static final Logger commandProviderLog = Logger.getLogger(CommandProvider.class.getName());
	
	CommandProvider(){
		repository.put(CommandName.GET, new GetNoteCommand());
		repository.put(CommandName.GET_TIME, new GetNoteByTimeCommand());
		repository.put(CommandName.GET_ALL, new GetAllNotesCommand());
		repository.put(CommandName.POST, new PostNoteCommand());
		repository.put(CommandName.UPDATE, new UpdateNoteCommand());
		repository.put(CommandName.DELETE, new DeleteNoteCommand());
		repository.put(CommandName.DELETE_ALL, new DeleteAllNotesCommand());
		repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
	}
	
	Executable getCommand(String name){
		CommandName commandName;
		Executable command;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e){
			commandProviderLog.log(Level.WARNING,"Error on getCommand call", e);
			command = repository.get(CommandName.WRONG_REQUEST);
		}				
		return command;
	}

}
