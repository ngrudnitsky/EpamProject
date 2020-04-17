package by.ngrudnitsky.mentoring.homework3.task2.service;

import by.ngrudnitsky.mentoring.homework3.task2.beans.Salary;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SalaryService {
    public Salary recountSalary(Salary salary) {
        if (salary != null) {
            if (isCrisis()) {
                salary.setSalaryAmount(salary.getSalaryAmount() * Math.random());
                System.out.println("Crisis! Some salaries are down!");
            } else {
                salary.setSalaryAmount(salary.getSalaryAmount() * (Math.random() * 2 + 1));
                System.out.println("Stable environment, some salaries are rising");
            }
        }
        return salary;
    }

    private boolean isCrisis() {
        return new Random().nextBoolean();
    }
}
