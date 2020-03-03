package by.epam.nickgrudnitsky.project;

import by.epam.nickgrudnitsky.project.util.output.ConsolePrinter;
import by.epam.nickgrudnitsky.project.view.View;
import by.epam.nickgrudnitsky.project.view.impl.ConsoleView;

public class ProgramRunner {
    public static void main(String[] args) {
        View view = new ConsoleView();
        view.runProgram(new ConsolePrinter());
    }
}
