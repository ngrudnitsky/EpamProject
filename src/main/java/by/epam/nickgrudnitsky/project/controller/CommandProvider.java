package by.epam.nickgrudnitsky.project.controller;

import by.epam.nickgrudnitsky.project.controller.command.Command;
import by.epam.nickgrudnitsky.project.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    CommandProvider() {
        commands.put(CommandName.GET_ALL_VEHICLES, new GetAllVehiclesCommand());
        commands.put(CommandName.GET_ALL_TRUCKS, new GetAllTrucksCommand());
        commands.put(CommandName.GET_ALL_CARGO_AIRPLANES, new GetAllCargoAirplanesCommand());
        commands.put(CommandName.GET_ALL_CARGO_SHIPS, new GetAllCargoShipsCommand());
        commands.put(CommandName.WRONG_REQUEST, new WrongCommand());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;

        try {
            commandName = CommandName.valueOf(name.toUpperCase().replaceAll(" ", "_"));
            command = commands.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            // TODO: 3/3/20 write log
            command = commands.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}