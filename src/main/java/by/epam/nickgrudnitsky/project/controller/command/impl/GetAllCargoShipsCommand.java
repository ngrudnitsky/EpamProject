package by.epam.nickgrudnitsky.project.controller.command.impl;

import by.epam.nickgrudnitsky.project.controller.command.Command;
import by.epam.nickgrudnitsky.project.exception.ServiceException;

public class GetAllCargoShipsCommand extends Command {
    @Override
    public String execute(String request) {
        String response;
        try {
            response = getVehicleService().getAllCargoShips().toString().concat("\n");
            return response;
        } catch (ServiceException e) {
            response = e.getMessage();
            getLogger().error(response);
            return response;
        }
    }
}
