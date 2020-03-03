package by.epam.nickgrudnitsky.project.exception;

public class VehicleCreatingException extends Exception {
    public VehicleCreatingException() {
    }

    public VehicleCreatingException(String message) {
        super(message);
    }

    public VehicleCreatingException(Exception e) {
        super(e);
    }

    public VehicleCreatingException(String message, Exception e) {
        super(message, e);
    }
}
