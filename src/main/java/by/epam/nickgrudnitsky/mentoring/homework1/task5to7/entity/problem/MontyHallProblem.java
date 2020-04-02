package by.epam.nickgrudnitsky.mentoring.homework1.task5to7.entity.problem;


import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.annotation.ProdCode;
import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.annotation.ThisCodeSmells;
import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.entity.output.Printer;
import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.util.Validator;

import java.util.Random;

import static by.epam.nickgrudnitsky.mentoring.homework1.task5to7.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.mentoring.homework1.task5to7.util.Validator.validateNumberOfChecks;

@ThisCodeSmells(reviewer = "Bob")
public class MontyHallProblem extends Problem {
    @ThisCodeSmells(reviewer = "Nick")
    private boolean chosenDoor;
    private int numberOfChecks;
    @ThisCodeSmells(reviewer = "Nick")
    private int numberOfWinningsWhenChangeChoice = 0;
    private int numberOfWinningsWhenDoNotChangeChoice = 0;
    @ThisCodeSmells(reviewer = "Bob")
    private static Random random = new Random();
    private static final int DOORS = 3;

    @ThisCodeSmells(reviewer = "Nick")
    public void checkAlgorithm(Printer printer) {
        printer.print(gerIntroductionMessage());

        numberOfChecks = readNumber();

        if (validateNumberOfChecks(numberOfChecks)) {
            runCheck();
        } else {
            printer.print(getValidationFailureMessage());
            checkAlgorithm(printer);
            return;
        }

        printer.print(getResultsMessage());

        numberOfWinningsWhenChangeChoice = 0;
        numberOfWinningsWhenDoNotChangeChoice = 0;
    }

    public MontyHallProblem() {
        setName("Monty Hall problem.");
    }

    @ThisCodeSmells(reviewer = "Nick")
    private void runCheck() {
        for (int i = 0; i < numberOfChecks; i++) {

            chooseDoor();

            if (chosenDoor) {
                numberOfWinningsWhenDoNotChangeChoice++;
            } else {
                numberOfWinningsWhenChangeChoice++;
            }
        }
    }

    @ProdCode
    private void chooseDoor() {
        chosenDoor = random.nextInt(DOORS) + 1 == 1;
    }

    @ProdCode
    private String gerIntroductionMessage() {
        return "Enter the number of checks.\n";
    }

    private String getValidationFailureMessage() {
        return String.format("The number of checks must be between %d and %d.\n",
                Validator.MIN_NUMBER_OF_CHECKS, Validator.MAX_NUMBER_OF_CHECKS);
    }

    private String getResultsMessage() {
        return String.format("Wins out of %d:\n   when changing choices - %d.\n   when do not changing choices - %d.\n",
                numberOfChecks, numberOfWinningsWhenChangeChoice, numberOfWinningsWhenDoNotChangeChoice);
    }
}
