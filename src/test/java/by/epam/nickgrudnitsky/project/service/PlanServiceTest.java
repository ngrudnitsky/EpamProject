package by.epam.nickgrudnitsky.project.service;

import by.epam.nickgrudnitsky.project.entities.Plan;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

import java.util.List;

public class PlanServiceTest {
    private PlanService planService = new PlanService();
    
    @Before
    public void setUp(){
        planService.readPlans(new File("src/main/resources/plansList.txt"));
    }


    @Test
    public void testReadPlans(){
        PlanService localPlans = new PlanService();
        List<Plan> plans = localPlans.readPlans(new File("src/main/resources/plansList.txt"));
        assertEquals(plans.toString(), "[Тариф Мобильный \"Абсолют\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 143.41\n" +
                ", Тариф Мобильный \"Безлимитище 2.0\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 22.5\n" +
                ", Тариф Мобильный \"ULTRA\"\n" +
                "Включено интернет трафика 10.0\n" +
                "абонентская плата 52.98\n" +
                ", Тариф Для Квартиры \"X5\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 26.5\n" +
                ", Тариф Для Квартиры \"X6\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 37.0\n" +
                ", Тариф Для Дома\n" +
                "Включено интернет трафика 100.0\n" +
                "абонентская плата 50.0\n" +
                "]");

    }

    @Test
    public void testGetAll(){
        assertEquals(planService.getAll().toString(), "[Тариф Мобильный \"Абсолют\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 143.41\n" +
                ", Тариф Мобильный \"Безлимитище 2.0\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 22.5\n" +
                ", Тариф Мобильный \"ULTRA\"\n" +
                "Включено интернет трафика 10.0\n" +
                "абонентская плата 52.98\n" +
                ", Тариф Для Квартиры \"X5\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 26.5\n" +
                ", Тариф Для Квартиры \"X6\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 37.0\n" +
                ", Тариф Для Дома\n" +
                "Включено интернет трафика 100.0\n" +
                "абонентская плата 50.0\n" +
                "]");

    }

    @Test
    public void testCountSubscribers(){
        int expResult = 100_630;
        int result = planService.countSubscribers();
        assertEquals(expResult, result);
    }

    @Test
    public void testSortBySubscriptionFee(){
        List<Plan> plans = planService.sortBySubscriptionFee();
        assertEquals(plans.toString(), "[Тариф Мобильный \"Безлимитище 2.0\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 22.5\n" +
                ", Тариф Для Квартиры \"X5\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 26.5\n" +
                ", Тариф Для Квартиры \"X6\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 37.0\n" +
                ", Тариф Для Дома\n" +
                "Включено интернет трафика 100.0\n" +
                "абонентская плата 50.0\n" +
                ", Тариф Мобильный \"ULTRA\"\n" +
                "Включено интернет трафика 10.0\n" +
                "абонентская плата 52.98\n" +
                ", Тариф Мобильный \"Абсолют\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 143.41\n" +
                "]");

    }

    @Test
    public void testSortByInternetTraffic(){
        List<Plan> plans = planService.sortByInternetTraffic();
        assertEquals(plans.toString(), "[Тариф Для Дома\n" +
                "Включено интернет трафика 100.0\n" +
                "абонентская плата 50.0\n" +
                ", Тариф Мобильный \"ULTRA\"\n" +
                "Включено интернет трафика 10.0\n" +
                "абонентская плата 52.98\n" +
                ", Тариф Мобильный \"Абсолют\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 143.41\n" +
                ", Тариф Мобильный \"Безлимитище 2.0\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 22.5\n" +
                ", Тариф Для Квартиры \"X5\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 26.5\n" +
                ", Тариф Для Квартиры \"X6\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 37.0\n" +
                "]");

    }

    @Test
    public void testSortByInternetTrafficAndFee(){
        List<Plan> plans = planService.sortByInternetTrafficAndFee();
        assertEquals(plans.toString(), "[Тариф Мобильный \"Безлимитище 2.0\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 22.5\n" +
                ", Тариф Для Квартиры \"X5\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 26.5\n" +
                ", Тариф Для Квартиры \"X6\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 37.0\n" +
                ", Тариф Мобильный \"Абсолют\"\n" +
                "Включено интернет трафика -1.0\n" +
                "абонентская плата 143.41\n" +
                ", Тариф Мобильный \"ULTRA\"\n" +
                "Включено интернет трафика 10.0\n" +
                "абонентская плата 52.98\n" +
                ", Тариф Для Дома\n" +
                "Включено интернет трафика 100.0\n" +
                "абонентская плата 50.0\n" +
                "]");

    }


}
