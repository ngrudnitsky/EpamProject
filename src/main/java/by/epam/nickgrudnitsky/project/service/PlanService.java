package by.epam.nickgrudnitsky.project.service;


import by.epam.nickgrudnitsky.project.data.PlanRepository;
import by.epam.nickgrudnitsky.project.entities.Plan;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static by.epam.nickgrudnitsky.project.service.Parser.readPlansFromFile;
import static by.epam.nickgrudnitsky.project.service.PlanValidator.validatePlans;


class PlanService {
    private PlanRepository planRepository = new PlanRepository();
    private static final Logger log = Logger.getLogger(PlanService.class);

    //Чтени входных данных из файла
    List<Plan> readPlans(File file) {
        List<List<String>> plansInfo = readPlansFromFile(file);

        if (validatePlans(plansInfo)) {
            List<Plan> plans = planRepository.createPlans(plansInfo);
            log.info("Введены тарифы из файла " + file.getName() + ".");

            return plans;
        }

        return new ArrayList<>();
    }

    //Подсчет общего числа клиентов (условие задания)
    int countSubscribers() {

        int subscribersAmount = 0;

        for (Plan plan : planRepository.getPlans()) {
            subscribersAmount += plan.getConnectedSubscribers();
        }
        return subscribersAmount;
    }

    List<Plan> getAll() {
        return planRepository.getPlans();
    }

    List<Plan> sortBySubscriptionFee() {  //сортировка тарифов по абонентской плате
        List<Plan> plans = planRepository.getPlans();

        plans.sort(new SubscriptionFeeComparator());
        log.info("Тарифы отсортированны по цене абонентской платы.");
        return plans;
    }

    List<Plan> sortByInternetTraffic() { //сортировка тарифов по включенному интернет трафику
        List<Plan> plans = planRepository.getPlans();

        plans.sort(new InternetTrafficComparator().reversed());
        log.info("Тарифы отсортированны по количеству включенного интернет трафика.");
        return plans;
    }

    List<Plan> sortByInternetTrafficAndFee() { //сортировка тарифов по включенному интернет трафику
        List<Plan> plans = planRepository.getPlans();  //и абонентской плате

        plans.sort(new InternetTrafficComparator().thenComparing(new SubscriptionFeeComparator()));
        log.info("Тарифы отсортированны по цене абонентской платы и количеству включенного интернет трафика.");
        return plans;
    }

}
