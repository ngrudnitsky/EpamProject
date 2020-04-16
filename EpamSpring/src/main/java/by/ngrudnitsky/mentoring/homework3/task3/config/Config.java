package by.ngrudnitsky.mentoring.homework3.task3.config;

import by.ngrudnitsky.mentoring.homework3.task3.ProgramRunner;
import by.ngrudnitsky.mentoring.homework3.task3.beans.Employee;
import by.ngrudnitsky.mentoring.homework3.task3.beans.Position;
import by.ngrudnitsky.mentoring.homework3.task3.beans.Salary;
import by.ngrudnitsky.mentoring.homework3.task3.service.EmployeeService;
import by.ngrudnitsky.mentoring.homework3.task3.service.PositionService;
import by.ngrudnitsky.mentoring.homework3.task3.service.SalaryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
    @Bean
    public Salary juneSalary() {
        return new Salary(100.);
    }

    @Bean
    public Salary middleSalary() {
        return new Salary(200.);
    }

    @Bean
    public Salary seniorSalary() {
        return new Salary(300.);
    }

    @Bean
    public Salary teamLeaderSalary() {
        return new Salary(400.);
    }

    @Bean
    public Position juniorPosition() {
        return new Position("Junior backend developer", juneSalary());
    }

    @Bean
    public Position middlePosition() {
        return new Position("Middle backend developer", middleSalary());
    }

    @Bean
    public Position seniorPosition() {
        return new Position("Senior backend developer", seniorSalary());
    }

    @Bean
    public Position projectTeamLeaderPosition() {
        return new Position("Project team leader", teamLeaderSalary());
    }

    @Bean
    public Employee bob() {
        return new Employee("Bob");
    }

    @Bean
    public Employee dan() {
        return new Employee("Dan");
    }

    @Bean
    public Employee john() {
        return new Employee("John");
    }

    @Bean
    public Employee steve() {
        return new Employee("Steve");
    }

    @Bean
    public Employee ban() {
        return new Employee("Ban");
    }

    @Bean
    public Employee mike() {
        return new Employee("Mike");
    }


    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }

    @Bean
    public PositionService positionService() {
        return new PositionService();
    }

    @Bean
    public SalaryService salaryService() {
        return new SalaryService();
    }

    @Bean
    public ProgramRunner programRunner() {
        return new ProgramRunner();
    }
}
