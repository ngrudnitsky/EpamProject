package by.epam.nickgrudnitsky.project.util.output;

public class ConsolePrinter implements Printer {
    @Override
    public final void print(String message) {
        System.out.print(message);
    }
}
