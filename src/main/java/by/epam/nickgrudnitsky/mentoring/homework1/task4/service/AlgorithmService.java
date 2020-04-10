package by.epam.nickgrudnitsky.mentoring.homework1.task4.service;


import by.epam.nickgrudnitsky.mentoring.homework1.task4.entity.output.Printer;
import by.epam.nickgrudnitsky.mentoring.homework1.task4.entity.problem.BirthdayProblem;
import by.epam.nickgrudnitsky.mentoring.homework1.task4.entity.problem.MarriageProblem;
import by.epam.nickgrudnitsky.mentoring.homework1.task4.entity.problem.MontyHallProblem;
import by.epam.nickgrudnitsky.mentoring.homework1.task4.entity.problem.Problem;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static by.epam.nickgrudnitsky.mentoring.homework1.task4.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.mentoring.homework1.task4.util.Validator.validateMenuItem;


public class AlgorithmService {
    private Map<Integer, Problem> startupMenu = new HashMap<>();
    private Printer printer;

    public AlgorithmService() {
        initializeStartupMeany();
    }

    private void initializeStartupMeany() {
        try {
            addMeanyItem((MontyHallProblem) Class.forName(MontyHallProblem.class.getName()).newInstance());
            addMeanyItem((BirthdayProblem) Class.forName(BirthdayProblem.class.getName()).newInstance());
            addMeanyItem((MarriageProblem) Class.forName(MarriageProblem.class.getName()).newInstance());

            changePrivateFieldWithoutSetter();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void changePrivateFieldWithoutSetter() {
        try {
            for (Problem value : startupMenu.values()) {
                Field nameField = value.getClass().getSuperclass().getDeclaredField("name");
                nameField.setAccessible(true);
                nameField.set(value, "Used reflection API to fill private fields without setters");
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void addMeanyItem(Problem problem) {
        startupMenu.put(startupMenu.size() + 1, problem);
    }

    public void runProgram(Printer printer) {
        int menuItem;
        this.printer = printer;

        outputMenuToConsole(startupMenu);

        menuItem = readNumber();

        if (validateMenuItem(menuItem)) {
            process(menuItem);
        } else {
            printer.print(getMenuValidationFailureMessage());
            runProgram(printer);
        }
    }

    private void process(int menuItem) {
        try {
            if (menuItem == 0) {
                return;
            }
            Problem problem = startupMenu.get(menuItem);
            Method checkAlgorithmMethod = problem.getClass().getDeclaredMethod("checkAlgorithm", Printer.class);
            checkAlgorithmMethod.invoke(problem, printer);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        runProgram(printer);
    }

    private void outputMenuToConsole(Map<Integer, Problem> startupMenu) {
        printer.print("Enter a number to continue:\n");

        for (Map.Entry<Integer, Problem> problem : startupMenu.entrySet()) {
            printer.print(problem.getKey() + " - " + problem.getValue().getName() + "\n");
        }

        printer.print("0 - Exit.\n");
    }

    private String getMenuValidationFailureMessage() {
        return "Choose from the given numbers.\n";
    }
}
