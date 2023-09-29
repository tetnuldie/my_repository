package edu.examples.java_classes.input;

import edu.examples.java_classes.input.command.Executable;
import edu.examples.java_classes.input.command.CommandProvider;
import edu.examples.java_classes.input.command.MenuCommand;

public class ConsoleMenu {

	public void execute() {

		Executable executable = CommandProvider.getInstance().getCommand(MenuCommand.SHOW_MAIN_MENU);
		executable.execute();

	}

}
