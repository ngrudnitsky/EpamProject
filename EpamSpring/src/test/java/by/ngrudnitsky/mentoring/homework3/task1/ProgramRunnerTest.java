package by.ngrudnitsky.mentoring.homework3.task1;

import by.ngrudnitsky.mentoring.homework3.task1.beans.Employee;
import by.ngrudnitsky.mentoring.homework3.task1.beans.Salary;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProgramRunnerTest {
    private Validator validator;
    private ApplicationContext context;

    @BeforeEach
    void init() {
        this.context = new ClassPathXmlApplicationContext("task1beans.xml");
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        this.validator = vf.getValidator();
    }

    @Test
    void validateEmployeeBobBean() {
        Set<ConstraintViolation<Employee>> violations = validator.validate(context.getBean("Bob", Employee.class));
        String message = "";
        if (!violations.isEmpty()) {
            message = violations.iterator().next().getMessage();
        }
        assertTrue(violations.isEmpty(), message);
    }

    @Test
    void validateEmployeeDanBean() {
        Set<ConstraintViolation<Employee>> violations = validator.validate(context.getBean("Dan", Employee.class));
        String message = "";
        if (!violations.isEmpty()) {
            message = violations.iterator().next().getMessage();
        }
        assertTrue(violations.isEmpty(), message);
    }

    @Test
    void validateEmployeeJohnBean() {
        Set<ConstraintViolation<Employee>> violations = validator.validate(context.getBean("John", Employee.class));
        String message = "";
        if (!violations.isEmpty()) {
            message = violations.iterator().next().getMessage();
        }
        assertTrue(violations.isEmpty(), message);
    }

    @Test
    void validateEmployeeSteveBean() {
        Set<ConstraintViolation<Employee>> violations = validator.validate(context.getBean("Steve", Employee.class));
        String message = "";
        if (!violations.isEmpty()) {
            message = violations.iterator().next().getMessage();
        }
        assertTrue(violations.isEmpty(), message);
    }

    @Test
    void validateEmployeeBanBean() {
        Set<ConstraintViolation<Employee>> violations = validator.validate(context.getBean("Ban", Employee.class));
        String message = "";
        if (!violations.isEmpty()) {
            message = violations.iterator().next().getMessage();
        }
        assertTrue(violations.isEmpty(), message);
    }

    @Test
    void validateJuneSalary() {
        Set<ConstraintViolation<Salary>> violations = validator.validate(context.getBean("JunSalary", Salary.class));
        String message = "";
        if (!violations.isEmpty()) {
            message = violations.iterator().next().getMessage();
        }
        assertTrue(violations.isEmpty(), message);
    }

    @Test
    void validateMiddleSalary() {
        Set<ConstraintViolation<Salary>> violations = validator.validate(context.getBean("MiddleSalary", Salary.class));
        String message = "";
        if (!violations.isEmpty()) {
            message = violations.iterator().next().getMessage();
        }
        assertTrue(violations.isEmpty(), message);
    }

    @Test
    void validateSeniorSalary() {
        Set<ConstraintViolation<Salary>> violations = validator.validate(context.getBean("SeniorSalary", Salary.class));
        String message = "";
        if (!violations.isEmpty()) {
            message = violations.iterator().next().getMessage();
        }
        assertTrue(violations.isEmpty(), message);
    }

    @Test
    void validateTeamLeaderSalary() {
        Set<ConstraintViolation<Salary>> violations = validator.validate(context.getBean("TeamLeaderSalary", Salary.class));
        String message = "";
        if (!violations.isEmpty()) {
            message = violations.iterator().next().getMessage();
        }
        assertTrue(violations.isEmpty(), message);
    }
}