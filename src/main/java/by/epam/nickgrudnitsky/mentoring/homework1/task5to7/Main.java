package by.epam.nickgrudnitsky.mentoring.homework1.task5to7;

import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.entity.output.ConsolePrinter;
import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.service.AlgorithmService;

public class Main {
    public static void main(String[] args) {
        AlgorithmService service = new AlgorithmService();
        service.runProgram(new ConsolePrinter());
    }
}
