package by.epam.nickgrudnitsky.project.view.impl;

import by.epam.nickgrudnitsky.project.controller.Controller;
import by.epam.nickgrudnitsky.project.exception.DataInputException;
import by.epam.nickgrudnitsky.project.factory.ControllerFactory;
import by.epam.nickgrudnitsky.project.util.output.Printer;
import by.epam.nickgrudnitsky.project.view.View;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.epam.nickgrudnitsky.project.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.project.util.Validator.validateMenuItem;

public class ConsoleView implements View {
    private static final Logger logger = Logger.getLogger(ConsoleView.class);
    private Map<Integer, String> startupMenu = new HashMap<>();
    private static final String VALIDATION_FAILURE_MESSAGE = "Choose from the given numbers.\n";
    private final Controller controller;
    private Printer printer;

    public ConsoleView() {
        controller = ControllerFactory.getInstance().getController();
        startupMenu.put(1, "Get all vehicles");
        startupMenu.put(2, "Get all trucks");
        startupMenu.put(3, "Get all cargo airplanes");
        startupMenu.put(4, "Get all cargo ships");
    }

    @Override
    public void runProgram(Printer printer) {
        int menuItem;
        this.printer = printer;

        outputMenuToConsole(startupMenu);

        try {
            menuItem = readNumber();
        } catch (DataInputException e) {
            logger.error(e.getMessage());
            menuItem = -1;
        }

        if (validateMenuItem(menuItem)) {
            process(menuItem);
        } else {
            printer.print(VALIDATION_FAILURE_MESSAGE);
            runProgram(printer);
        }
    }


    private void process(int menuItem) {
        if (menuItem == 0) {
            return;
        }
        String response = controller.executeTask(startupMenu.get(menuItem));
        printer.print(response);
        runProgram(printer);
    }

    private void outputMenuToConsole(Map<Integer, String> startupMenu) {
        printer.print("Enter a number to continue:\n");

        for (Map.Entry<Integer, String> command : startupMenu.entrySet()) {
            printer.print(command.getKey() + " - " + command.getValue() + "\n");
        }

        printer.print("0 - Exit.\n");
    }

}
