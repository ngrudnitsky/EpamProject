package by.ngrudnitsky.mentoring.homework3.examples.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Human {
    private String name ;
    private Integer weight;
    private Head head;

    public void talk(){
        System.out.println("Says something.");
    }

    public Human(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public Human() {
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", head=" + head +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (getName() != null ? !getName().equals(human.getName()) : human.getName() != null) return false;
        if (getWeight() != null ? !getWeight().equals(human.getWeight()) : human.getWeight() != null) return false;
        return getHead() != null ? getHead().equals(human.getHead()) : human.getHead() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getWeight() != null ? getWeight().hashCode() : 0);
        result = 31 * result + (getHead() != null ? getHead().hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    @Required
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Head getHead() {
        return head;
    }

    @Autowired
    public void setHead(Head head) {
        this.head = head;
    }
}
