package edu.examples.java_classes.input.command;

import java.util.LinkedHashMap;
import java.util.Map;

import edu.examples.java_classes.input.command.request.*;
import edu.examples.java_classes.input.command.navigation.*;

public class CommandProvider {
	private static final CommandProvider instance = new CommandProvider();
	
	private Map<MenuCommand, Executable> commands = new LinkedHashMap<>();
	
	
	private CommandProvider() {
		commands.put(MenuCommand.SHOW_MAIN_MENU, new ConsoleShowMainMenu());
		commands.put(MenuCommand.SHOW_SEARCH_MENU, new ConsoleShowFindMenu());
		commands.put(MenuCommand.CREATE_NEW_ITEM, new ConsoleCreateNewItem());
		commands.put(MenuCommand.FIND_BY_DATE, new ConsoleFindItemByDate());
		commands.put(MenuCommand.FIND_BY_CONTENT, new ConsoleFindItemByContent());
		commands.put(MenuCommand.EDIT_NOTE_MENU, new ConsoleShowEditMenu());
		commands.put(MenuCommand.UPDATE_NOTE, new ConsoleUpdateItem());
		commands.put(MenuCommand.DELETE_NOTE, new ConsoleDeleteNote());
		commands.put(MenuCommand.CLEAR_ALL_NOTES, new ConsoleDeleteAll());
		commands.put(MenuCommand.NO_MENU_ACTION, new ConsoleNoAction());
		commands.put(MenuCommand.EXIT_CODE, new ConsoleExitCode());
	}
	
	public Executable getCommand(MenuCommand commandName) {
		return commands.get(commandName);
	}

	public static CommandProvider getInstance() {
		return instance;
	}

}
