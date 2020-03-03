package by.epam.nickgrudnitsky.project.util;


import by.epam.nickgrudnitsky.project.controller.CommandName;

public class Validator {
    public static final int MIN_MENU_NUMBER = 0;
    public static final int MAX_MENU_NUMBER = CommandName.values().length;

    private Validator() {
    }

    public static boolean validateMenuItem(int number) {
        return number >= MIN_MENU_NUMBER && number < MAX_MENU_NUMBER;
    }
}
