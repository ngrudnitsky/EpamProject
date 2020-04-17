package by.ngrudnitsky.mentoring.homework3.task3.service;

import by.ngrudnitsky.mentoring.homework3.task3.beans.Employee;
import by.ngrudnitsky.mentoring.homework3.task3.beans.Position;

public class EmployeeService {
    public void hire(Employee employee, Position position) {
        if (employee != null && position != null) {
            employee.setPosition(position);
            employee.setSalary(position.getSalary());
            position.getEmployees().add(employee);
        }
    }

    public void fire(Employee employee) {
        if (employee != null) {
            Position position = employee.getPosition();
            employee.setPosition(null);
            position.getEmployees().remove(employee);
        }
    }
}
