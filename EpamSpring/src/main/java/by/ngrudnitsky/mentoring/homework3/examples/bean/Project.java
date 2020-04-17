package by.ngrudnitsky.mentoring.homework3.examples.bean;

@SuppressWarnings("unused")
public class Project {
    private String name;
    private Developer teamLead;

    public Project(String name, Developer teamLead) {
        this.name = name;
        this.teamLead = teamLead;
    }

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(Developer teamLead) {
        this.teamLead = teamLead;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", teamLead=" + teamLead +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        return teamLead != null ? teamLead.equals(project.teamLead) : project.teamLead == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (teamLead != null ? teamLead.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Developer getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(Developer teamLead) {
        this.teamLead = teamLead;
    }
}
