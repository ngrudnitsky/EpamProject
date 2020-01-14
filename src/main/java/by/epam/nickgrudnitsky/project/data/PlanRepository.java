package by.epam.nickgrudnitsky.project.data;


import by.epam.nickgrudnitsky.project.entitie.ApartmentPlan;
import by.epam.nickgrudnitsky.project.entitie.CellularPlan;
import by.epam.nickgrudnitsky.project.entitie.Plan;
import by.epam.nickgrudnitsky.project.entitie.PrivateHousePlan;

import java.util.ArrayList;
import java.util.List;


//Класс, который работает со всей базой тарифных планов (замена базы данных)

public class PlanRepository {

    //тут хранятся все прочитанные тарифы
    private List<Plan> plans = new ArrayList<>();

    //добавление плана в базу
    private void addPlan(Plan plan) {
        plans.add(plan);
    }

    //создание планов из входных данных
    public List<Plan> createPlans(List<List<String>> plansInfo){

        for (List<String> planInfo : plansInfo) {

            String tariffType = planInfo.get(0);

            if (tariffType.startsWith("Тариф Мобильный")){
                CellularPlan cellularPlan = new CellularPlan();

                fillCellularPlan(cellularPlan, planInfo);
                addPlan(cellularPlan);

            } else if (tariffType.startsWith("Тариф Для Квартиры")) {
                ApartmentPlan apartmentPlan = new ApartmentPlan();

                fillApartmentPlan(apartmentPlan, planInfo);
                addPlan(apartmentPlan);

            } else if (tariffType.startsWith("Тариф Для Дома")){
                PrivateHousePlan privateHousePlan = new PrivateHousePlan();

                fillPrivateHousePlan(privateHousePlan, planInfo);
                addPlan(privateHousePlan);

            }
        }
        return plans;
    }


    private void fillCellularPlan(CellularPlan cellularPlan, List<String> planInfo){

        cellularPlan.setName(planInfo.get(0));
        cellularPlan.setVolumeOfInternetTraffic(Double.valueOf(planInfo.get(1)));
        cellularPlan.setOutgoingInternetPrice(Double.valueOf(planInfo.get(2)));
        cellularPlan.setMobileHotspot(Double.valueOf(planInfo.get(3)));
        cellularPlan.setMinutesOnCall(Integer.valueOf(planInfo.get(4)));
        cellularPlan.setOutgoingCallsPrice(Double.valueOf(planInfo.get(5)));
        cellularPlan.setRoamingCallPrice(Double.valueOf(planInfo.get(6)));
        cellularPlan.setSms(Double.valueOf(planInfo.get(7)));
        cellularPlan.setMtsTvTraffic(Double.valueOf(planInfo.get(8)));
        cellularPlan.setSubscriptionFee(Double.valueOf(planInfo.get(9)));
        cellularPlan.setConnectionPrice(Double.valueOf(planInfo.get(10)));
        cellularPlan.setConnectedSubscribers(Integer.valueOf(planInfo.get(11)));
    }

    private void fillApartmentPlan(ApartmentPlan apartmentPlan, List<String> planInfo){
        apartmentPlan.setName(planInfo.get(0));
        apartmentPlan.setVolumeOfInternetTraffic(Double.valueOf(planInfo.get(1)));
        apartmentPlan.setSubscriptionFee(Double.valueOf(planInfo.get(2)));
        apartmentPlan.setConnectionPrice(Double.valueOf(planInfo.get(3)));
        apartmentPlan.setConnectedSubscribers(Integer.valueOf(planInfo.get(4)));
        apartmentPlan.setDrWebAntivirus(Boolean.valueOf(planInfo.get(5)));
        apartmentPlan.setWifiRouter(Boolean.valueOf(planInfo.get(6)));
        apartmentPlan.setTv(Boolean.valueOf(planInfo.get(7)));
        apartmentPlan.setAccessSpeed(Integer.valueOf(planInfo.get(8)));
    }

    private void fillPrivateHousePlan(PrivateHousePlan privateHousePlan, List<String> planInfo){
        privateHousePlan.setName(planInfo.get(0));
        privateHousePlan.setVolumeOfInternetTraffic(Double.valueOf(planInfo.get(1)));
        privateHousePlan.setTrafficVolumeOn1MbeatSpeed(Double.valueOf(planInfo.get(2)));
        privateHousePlan.setSubscriptionFee(Double.valueOf(planInfo.get(3)));
        privateHousePlan.setConnectionPrice(Double.valueOf(planInfo.get(4)));
        privateHousePlan.setConnectedSubscribers(Integer.valueOf(planInfo.get(5)));
        privateHousePlan.setDrWebAntivirus(Boolean.valueOf(planInfo.get(6)));
        privateHousePlan.setWifiRouter(Boolean.valueOf(planInfo.get(7)));
        privateHousePlan.setTv(Boolean.valueOf(planInfo.get(8)));
    }


    public List<Plan> getPlans() {
        return plans;
    }
}
