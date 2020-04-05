package by.epam.nickgrudnitsky.mentoring.homework2.test.beans;

@SuppressWarnings("unused")
public class Employee {

    private int age;
    private String name;
    private  String skill;
    private int level;
    private Department department;

    public Employee(int age, String name, String skill, int level, Department department) {
        this.age = age;
        this.name = name;
        this.skill = skill;
        this.level = level;
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", level=" + level +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (getAge() != employee.getAge()) return false;
        if (getLevel() != employee.getLevel()) return false;
        if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
        if (getSkill() != null ? !getSkill().equals(employee.getSkill()) : employee.getSkill() != null) return false;
        return getDepartment() != null ? getDepartment().equals(employee.getDepartment()) : employee.getDepartment() == null;
    }

    @Override
    public int hashCode() {
        int result = getAge();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSkill() != null ? getSkill().hashCode() : 0);
        result = 31 * result + getLevel();
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        return result;
    }
}
