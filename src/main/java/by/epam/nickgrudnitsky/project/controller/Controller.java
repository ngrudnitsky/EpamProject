package by.epam.nickgrudnitsky.project.controller;

import by.epam.nickgrudnitsky.project.controller.command.Command;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;

        commandName = request;
        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request);

        return response;
    }
}