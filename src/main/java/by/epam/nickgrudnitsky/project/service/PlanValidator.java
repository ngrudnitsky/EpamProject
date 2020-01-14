package by.epam.nickgrudnitsky.project.service;

import by.epam.nickgrudnitsky.project.exception.PlanValidationException;
import org.apache.log4j.Logger;

import java.util.List;

class PlanValidator {
    private static final Logger log = Logger.getLogger(PlanService.class);

    //метод принимает список тарифов на валидацию
    static boolean validatePlans(List<List<String>> plans) {
        for (List<String> plan : plans) {
            if (!validatePlan(plan)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validatePlan(List<String> plan) {

        //проверяем корректность названия тарифа и продолжаем валидацию, если все верно
        if (validateName(plan.get(0))) {

            for (int i = 1; i < plan.size(); i++) {
                try {
                    //выходим из метода, если хоть одна из проверок не сошлась
                    if (!validateTraffic(plan.get(i))) {
                        return false;
                    }
                } catch (PlanValidationException | NumberFormatException e) {
                    log.error(String.format("Неверный параметр тарифа %s в строке %d", plan.get(i), i));
                    System.out.println("Invalid input data");
                }
            }
        }

        return true;
    }

    private static boolean validateName(String name) {

        if (name.startsWith("Тариф Мобильный") || name.startsWith("Тариф Для Квартиры") || name.startsWith("Тариф Для Дома")) {
            return true;
        } else {
            try {
                throw new PlanValidationException();
            } catch (PlanValidationException e) {
                log.error(String.format("Неверное имя тарифа %s", name));
                System.out.println("Invalid input data");
            }
        }
        return false;
    }

    private static boolean validateTraffic(String traffic) throws PlanValidationException, NumberFormatException {
        double number;

        number = Double.parseDouble(traffic);

        if (number >= 0 || number == -1) {

            return true;
        } else {
            throw new PlanValidationException();
        }
    }
}
