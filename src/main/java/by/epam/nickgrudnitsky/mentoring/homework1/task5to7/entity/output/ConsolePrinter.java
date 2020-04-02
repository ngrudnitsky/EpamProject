package by.epam.nickgrudnitsky.mentoring.homework1.task5to7.entity.output;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.print(message);
    }
}
