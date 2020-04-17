package by.ngrudnitsky.mentoring.homework3.examples.bean;

@SuppressWarnings("unused")
public class Developer {
    private String name;
    private String skill;
    private int level;
    private boolean isCoffeeConsumer;

    public Developer() {
    }

    public Developer(String name, String skill, int level, boolean isCoffeeConsumer) {
        this.name = name;
        this.skill = skill;
        this.level = level;
        this.isCoffeeConsumer = isCoffeeConsumer;
    }

    public Developer(String name) {
        this.name = name;
    }

    public Developer(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", level=" + level +
                ", isCoffeeConsumer=" + isCoffeeConsumer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (level != developer.level) return false;
        if (isCoffeeConsumer != developer.isCoffeeConsumer) return false;
        if (name != null ? !name.equals(developer.name) : developer.name != null) return false;
        return skill != null ? skill.equals(developer.skill) : developer.skill == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (skill != null ? skill.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + (isCoffeeConsumer ? 1 : 0);
        return result;
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

    public boolean isCoffeeConsumer() {
        return isCoffeeConsumer;
    }

    public void setCoffeeConsumer(boolean coffeeConsumer) {
        isCoffeeConsumer = coffeeConsumer;
    }
}
