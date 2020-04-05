package by.epam.nickgrudnitsky.mentoring.homework2.test.beans;

import java.util.Map;

public class Developer {
    private String name;

    private Map<String, Integer> skillMatrix;

    public Developer(String name, Map<String, Integer> skillMatrix) {
        this.name = name;
        this.skillMatrix = skillMatrix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getSkillMatrix() {
        return skillMatrix;
    }

    public void setSkillMatrix(Map<String, Integer> skillMatrix) {
        this.skillMatrix = skillMatrix;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (getName() != null ? !getName().equals(developer.getName()) : developer.getName() != null) return false;
        return getSkillMatrix() != null ? getSkillMatrix().equals(developer.getSkillMatrix()) : developer.getSkillMatrix() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSkillMatrix() != null ? getSkillMatrix().hashCode() : 0);
        return result;
    }
}
