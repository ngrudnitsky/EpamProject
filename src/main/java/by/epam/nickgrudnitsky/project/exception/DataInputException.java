package by.epam.nickgrudnitsky.project.exception;

public class DataInputException extends Exception{
    public DataInputException() {
    }

    public DataInputException(String message) {
        super(message);
    }

    public DataInputException(Exception e) {
        super(e);
    }

    public DataInputException(String message, Exception e) {
        super(message, e);
    }
}
