package edu.examples.java_classes.start;

import edu.examples.java_classes.input.ConsoleMenu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;


public class Main {

    public static void main(String[] args) {

        try {
            FileInputStream logsConfig = new FileInputStream("D:\\Notebook\\Final\\notebook_mv\\notebook_mv\\src\\main\\java\\logging.properties");
            LogManager.getLogManager().readConfiguration(
                    logsConfig);
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e);
        }

        ConsoleMenu menu = new ConsoleMenu();

        menu.execute();

    }
}
