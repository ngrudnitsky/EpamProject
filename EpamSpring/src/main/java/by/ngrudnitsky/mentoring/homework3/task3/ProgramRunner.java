package by.ngrudnitsky.mentoring.homework3.task3;

import by.ngrudnitsky.mentoring.homework3.task3.beans.Employee;
import by.ngrudnitsky.mentoring.homework3.task3.beans.Position;
import by.ngrudnitsky.mentoring.homework3.task3.config.Config;
import by.ngrudnitsky.mentoring.homework3.task3.service.EmployeeService;
import by.ngrudnitsky.mentoring.homework3.task3.service.PositionService;
import by.ngrudnitsky.mentoring.homework3.task3.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("unused")
public class ProgramRunner {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private SalaryService salaryService;

    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    public static void main(String[] args) {
        ProgramRunner programRunner = context.getBean("programRunner", ProgramRunner.class);
        programRunner.emulateCompanyLife();
    }

    private void emulateCompanyLife() {
        Position juniorBackendDeveloper = context.getBean("juniorPosition", Position.class);
        Position seniorBackendDeveloper = context.getBean("middlePosition", Position.class);
        Position middleFrontendDeveloper = context.getBean("seniorPosition", Position.class);
        Position projectTeamLeader = context.getBean("projectTeamLeaderPosition", Position.class);

        positionService.create(juniorBackendDeveloper);
        positionService.create(seniorBackendDeveloper);
        positionService.create(middleFrontendDeveloper);
        positionService.create(projectTeamLeader);

        Employee bob = context.getBean("bob", Employee.class);
        Employee dan = context.getBean("dan", Employee.class);
        Employee john = context.getBean("john", Employee.class);
        Employee steve = context.getBean("steve", Employee.class);
        Employee ban = context.getBean("ban", Employee.class);

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
        Employee mike = context.getBean("mike", Employee.class);
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

    public ProgramRunner() {
    }
}
