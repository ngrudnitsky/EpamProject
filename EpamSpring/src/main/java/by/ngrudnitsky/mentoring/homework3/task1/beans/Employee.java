package by.ngrudnitsky.mentoring.homework3.task1.beans;

import javax.validation.constraints.NotNull;

@SuppressWarnings("unused")
public class Employee {
    @NotNull
    private String name;
    private Position position;
    private Salary salary;

    public Employee() {
    }

    public Employee(String name, Position position, Salary salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee: " +
                "name = '" + name + '\'' +
                ", position = " + position.getName() +
                ", salary = " + salary.getSalaryAmount() +
                ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
        if (getPosition() != null ? !getPosition().getName().equals(employee.getPosition().getName()) : employee.getPosition() != null)
            return false;
        return getSalary() != null ? getSalary().equals(employee.getSalary()) : employee.getSalary() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPosition() != null ? getPosition().getName().hashCode() : 0);
        result = 31 * result + (getSalary() != null ? getSalary().getSalaryAmount().hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
