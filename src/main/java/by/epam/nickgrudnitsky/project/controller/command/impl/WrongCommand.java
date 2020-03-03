package by.epam.nickgrudnitsky.project.controller.command.impl;

import by.epam.nickgrudnitsky.project.controller.command.Command;

public class WrongCommand extends Command {
    @Override
    public String execute(String request) {
        String response = "Wrong command";
        getLogger().error(response);
        return response;
    }
}
