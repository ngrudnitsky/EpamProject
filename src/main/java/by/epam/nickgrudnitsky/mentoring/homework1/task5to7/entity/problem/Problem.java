package by.epam.nickgrudnitsky.mentoring.homework1.task5to7.entity.problem;

import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.annotation.UseArrayList;
import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.annotation.UseStackOnly;
import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.entity.output.Printer;


public abstract class Problem {
    @UseStackOnly
    private String name;

    @UseArrayList
    public abstract void checkAlgorithm(Printer printer);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
