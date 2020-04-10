package by.epam.nickgrudnitsky.mentoring.homework1.task4;

import by.epam.nickgrudnitsky.mentoring.homework1.task4.entity.output.ConsolePrinter;
import by.epam.nickgrudnitsky.mentoring.homework1.task4.service.AlgorithmService;

public class Runner {
    public static void main(String[] args) {
        AlgorithmService algorithmService = null;
        try {
            algorithmService = (AlgorithmService) Class.forName(AlgorithmService.class.getName()).newInstance();
            algorithmService.runProgram((ConsolePrinter) Class.forName(ConsolePrinter.class.getName()).newInstance());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
