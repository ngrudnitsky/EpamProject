package by.epam.nickgrudnitsky.mentoring.homework1.task3.entity;

import java.util.List;

@SuppressWarnings("unused") //Used to suppress 'unused' warnings
public class Role extends BaseEntity {

    private static Long idCounter = 0L;
    private final Long id = ++idCounter;
    private String name;
    private List<User> users;

    @Override
    public String toString() {
        return "Role " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Role role = (Role) o;

        if (getId() != null ? !getId().equals(role.getId()) : role.getId() != null) return false;
        if (getName() != null ? !getName().equals(role.getName()) : role.getName() != null) return false;
        return getUsers() != null ? getUsers().equals(role.getUsers()) : role.getUsers() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getUsers() != null ? getUsers().hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
