package by.epam.nickgrudnitsky.project.controller.command;

import by.epam.nickgrudnitsky.project.factory.ServiceFactory;
import by.epam.nickgrudnitsky.project.service.VehicleService;
import org.apache.log4j.Logger;

public abstract class Command {
    private VehicleService vehicleService;
    private final Logger logger = Logger.getLogger(Command.class);

    public Command() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        vehicleService = serviceFactory.getVehicleService();
    }

    public abstract String execute(String request);

    public VehicleService getVehicleService() {
        return vehicleService;
    }

    public Logger getLogger() {
        return logger;
    }
}
