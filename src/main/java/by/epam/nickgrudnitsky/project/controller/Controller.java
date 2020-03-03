package by.epam.nickgrudnitsky.project.controller;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) {
        return  provider.getCommand(request).execute(request);

    }
}