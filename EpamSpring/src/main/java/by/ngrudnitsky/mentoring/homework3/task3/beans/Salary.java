package by.ngrudnitsky.mentoring.homework3.task3.beans;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Salary {
    @NotNull
    @PositiveOrZero
    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private Double salaryAmount;

    public Salary(Double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Salary() {
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryAmount=" + salaryAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salary salary = (Salary) o;

        return getSalaryAmount() != null ? getSalaryAmount().equals(salary.getSalaryAmount()) : salary.getSalaryAmount() == null;
    }

    @Override
    public int hashCode() {
        return getSalaryAmount() != null ? getSalaryAmount().hashCode() : 0;
    }

    public Double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(Double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }
}
