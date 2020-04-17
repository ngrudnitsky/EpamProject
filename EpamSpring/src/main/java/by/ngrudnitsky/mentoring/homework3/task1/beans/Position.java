package by.ngrudnitsky.mentoring.homework3.task1.beans;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Position {
    private String name;
    private Salary salary;
    private List<Employee> employees = new ArrayList<>();

    public Position() {
    }

    public Position(String name, Salary salary, List<Employee> employees) {
        this.name = name;
        this.salary = salary;
        this.employees = employees;
    }

    public Position(String name) {
        this.name = name;
    }

    public Position(String name, Salary salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        String template = String.format("Position: '%s', salary = %.2f, employees = [", name, salary.getSalaryAmount());
        StringBuilder result = new StringBuilder(template);

        for (int i = 0; i < employees.size(); i++) {
            result.append(employees.get(i).getName());
            if (i == employees.size() - 1) {
                break;
            }
            result.append(", ");
        }
        return result.append("]").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (getName() != null ? !getName().equals(position.getName()) : position.getName() != null) return false;
        if (getSalary() != null ? !getSalary().equals(position.getSalary()) : position.getSalary() != null)
            return false;
        return getEmployees() != null ? getEmployees().equals(position.getEmployees()) : position.getEmployees() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSalary() != null ? getSalary().getSalaryAmount().hashCode() : 0);
        result = 31 * result + (getEmployees() != null ? getEmployees().hashCode() : 0);
        return result;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

