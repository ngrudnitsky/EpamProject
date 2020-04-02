package by.epam.nickgrudnitsky.mentoring.homework1.task4.entity.problem;

import by.epam.nickgrudnitsky.mentoring.homework1.task4.entity.output.Printer;

public abstract class Problem {
    private String name;

    public abstract void checkAlgorithm(Printer printer);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
