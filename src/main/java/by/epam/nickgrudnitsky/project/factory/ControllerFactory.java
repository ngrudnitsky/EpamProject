package by.epam.nickgrudnitsky.project.factory;

import by.epam.nickgrudnitsky.project.controller.Controller;

public final class ControllerFactory {
    private static final ControllerFactory instance = new ControllerFactory();

    private final Controller controller = new Controller();

    private ControllerFactory() {
    }

    public static ControllerFactory getInstance() {
        return instance;
    }

    public Controller getController() {
        return controller;
    }
}
