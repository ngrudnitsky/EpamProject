package by.ngrudnitsky.mentoring.homework3.task1;

import by.ngrudnitsky.mentoring.homework3.task1.beans.Employee;
import by.ngrudnitsky.mentoring.homework3.task1.beans.Position;
import by.ngrudnitsky.mentoring.homework3.task1.service.EmployeeService;
import by.ngrudnitsky.mentoring.homework3.task1.service.PositionService;
import by.ngrudnitsky.mentoring.homework3.task1.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("unused")
public class ProgramRunner {
    private EmployeeService employeeService;
    private PositionService positionService;
    private SalaryService salaryService;
    private static final ApplicationContext context = new ClassPathXmlApplicationContext("task1beans.xml");

    public static void main(String[] args) {
        ProgramRunner programRunner = context.getBean("ProgramRunner", ProgramRunner.class);
        programRunner.emulateCompanyLife();
    }

    private void emulateCompanyLife() {
        Position juniorBackendDeveloper = context.getBean("Junior backend developer", Position.class);
        Position seniorBackendDeveloper = context.getBean("Senior backend developer", Position.class);
        Position middleFrontendDeveloper = context.getBean("Middle backend developer", Position.class);
        Position projectTeamLeader = context.getBean("Project team leader", Position.class);

        positionService.create(juniorBackendDeveloper);
        positionService.create(seniorBackendDeveloper);
        positionService.create(middleFrontendDeveloper);
        positionService.create(projectTeamLeader);

        Employee bob = context.getBean("Bob", Employee.class);
        Employee dan = context.getBean("Dan", Employee.class);
        Employee john = context.getBean("John", Employee.class);
        Employee steve = context.getBean("Steve", Employee.class);
        Employee ban = context.getBean("Ban", Employee.class);

        employeeService.hire(bob, juniorBackendDeveloper);
        employeeService.hire(dan, juniorBackendDeveloper);
        employeeService.hire(john, seniorBackendDeveloper);
        employeeService.hire(steve, middleFrontendDeveloper);
        employeeService.hire(ban, projectTeamLeader);
        System.out.println("January:");
        System.out.println(positionService.read("Junior backend developer"));
        System.out.println(positionService.read("Senior backend developer"));
        System.out.println(positionService.read("Middle backend developer"));
        System.out.println(positionService.read("Project team leader"));

        System.out.println("February:");
        juniorBackendDeveloper.setSalary(salaryService.recountSalary(juniorBackendDeveloper.getSalary()));
        System.out.println(juniorBackendDeveloper);

        System.out.println("March:");
        employeeService.fire(steve);
        System.out.println("Steve was fired.");
        middleFrontendDeveloper.setSalary(salaryService.recountSalary(middleFrontendDeveloper.getSalary()));
        System.out.println(middleFrontendDeveloper);

        System.out.println("April:");
        System.out.println("Mike was hired.");
        Employee mike = context.getBean("Mike", Employee.class);
        employeeService.hire(mike, middleFrontendDeveloper);
        System.out.println(middleFrontendDeveloper);

        System.out.println("May:");
        System.out.println("John was fired.");
        employeeService.fire(john);
        System.out.println(seniorBackendDeveloper);

        System.out.println("June:");
        System.out.println("Position senior backend developer was abolished.");
        positionService.delete(seniorBackendDeveloper);
        System.out.println(positionService.getAllPositions());
    }

    @Autowired
    public ProgramRunner(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }
}
