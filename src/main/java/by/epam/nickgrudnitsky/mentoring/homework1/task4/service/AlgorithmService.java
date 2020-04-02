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
        MontyHallProblem montyHallProblem = null;
        BirthdayProblem birthdayProblem = null;
        MarriageProblem marriageProblem = null;

        try {
            montyHallProblem = (MontyHallProblem) Class.forName(MontyHallProblem.class.getName()).newInstance();
            birthdayProblem = (BirthdayProblem) Class.forName(BirthdayProblem.class.getName()).newInstance();
            marriageProblem = (MarriageProblem) Class.forName(MarriageProblem.class.getName()).newInstance();

            Field montyName = montyHallProblem.getClass().getSuperclass().getDeclaredField("name");
            Field birthdayName = birthdayProblem.getClass().getSuperclass().getDeclaredField("name");
            Field marriageName = marriageProblem.getClass().getSuperclass().getDeclaredField("name");
            montyName.setAccessible(true);
            birthdayName.setAccessible(true);
            marriageName.setAccessible(true);
            montyName.set(montyHallProblem, "Reflection Monty");
            birthdayName.set(birthdayProblem, "Reflection Birthday");
            marriageName.set(marriageProblem, "Reflection Marriage");

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        startupMenu.put(1, montyHallProblem);
        startupMenu.put(2, birthdayProblem);
        startupMenu.put(3, marriageProblem);
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
        if (menuItem == 0) {
            return;
        }
        Problem problem = startupMenu.get(menuItem);
        try {
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
