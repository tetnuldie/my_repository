package edu.examples.java_classes.input;

import edu.examples.java_classes.input.command.MenuCommand;

public final class MenuBuilder {
	private static final MenuBuilder instance = new MenuBuilder();
	
	private final MenuSelectionSystem menuSystem = new MenuSelectionSystem();
	private final Display display = new Display();
	private final InputTerminal terminal = new InputTerminal();

	private MenuBuilder() {
		ConcreteMenu cm1 = new ConcreteMenu("MAIN MENU");
		cm1.setItems(MenuCommand.CREATE_NEW_ITEM.getConsoleCode(), "Create new note.");
		cm1.setItems(MenuCommand.SHOW_SEARCH_MENU.getConsoleCode(),"Search notes.");
		cm1.setItems(MenuCommand.EXIT_CODE.getConsoleCode(),"CLOSE APP");
		cm1.setItems(MenuCommand.EDIT_NOTE_MENU.getConsoleCode(),"Notes manager.");

		menuSystem.add(Menu.MAIN_MENU, cm1);

		ConcreteMenu cm2 = new ConcreteMenu("SEARCH NOTES");
		cm2.setItems(MenuCommand.GET_ALL_NOTES.getConsoleCode(),"Find all notes.");
		cm2.setItems(MenuCommand.FIND_BY_DATE.getConsoleCode(),"Find note by date.");
		cm2.setItems(MenuCommand.FIND_BY_CONTENT.getConsoleCode(),"Find note by content");
		cm2.setItems(MenuCommand.EXIT_CODE.getConsoleCode(), "BACK.");

		menuSystem.add(Menu.SEARCH_MENU, cm2);

		ConcreteMenu cm3 = new ConcreteMenu("CONTEXT MENU");
		menuSystem.add(Menu.CONTEXT_MENU, cm3);

		ConcreteMenu cm4 = new ConcreteMenu("NOTES MANAGER");
		cm4.setItems(MenuCommand.EXIT_CODE.getConsoleCode(), "BACK.");
		cm4.setItems(MenuCommand.UPDATE_NOTE.getConsoleCode(), "Edit note.");
		cm4.setItems(MenuCommand.DELETE_NOTE.getConsoleCode(), "Delete note.");
		cm4.setItems(MenuCommand.CLEAR_ALL_NOTES.getConsoleCode(),"Delete all notes.");


		menuSystem.add(Menu.EDIT_MENU, cm4);
	}

	public static MenuBuilder getInstance() {
		return instance;
	}

	public MenuSelectionSystem getMenuSystem() {
		return menuSystem;
	}

	public Display getDisplay() {
		return display;
	}

	public InputTerminal getTerminal() {
		return terminal;
	}
	
}
