package edu.examples.java_classes.input.command;

public enum MenuCommand {
    SHOW_MAIN_MENU(99), SHOW_SEARCH_MENU(1),

    CREATE_NEW_ITEM(2), EDIT_NOTE_MENU(3),
    GET_ALL_NOTES(4),
    FIND_BY_DATE(5), FIND_BY_CONTENT(6),
    UPDATE_NOTE(7), DELETE_NOTE(8), CLEAR_ALL_NOTES(9),
    NO_MENU_ACTION(-1), EXIT_CODE(0);

    private final int consoleCode;

    MenuCommand(int code) {
        consoleCode = code;
    }

    public int getConsoleCode() {
        return consoleCode;
    }

}
