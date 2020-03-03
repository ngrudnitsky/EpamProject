package by.epam.nickgrudnitsky.project.util;

import by.epam.nickgrudnitsky.project.exception.DataInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataInput {
    private DataInput() {
    }

    public static int readNumber() throws DataInputException{
        Scanner scanner = new Scanner(System.in);
        int number;

        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new DataInputException("Invalid input data.", e);
        }

        return number;
    }
}
