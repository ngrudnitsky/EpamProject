package by.ngrudnitsky.mentoring.homework3.examples.bean;

public class Head {
    private Integer iq;

    public Head() {
    }

    @Override
    public String toString() {
        return "Head{" +
                "iq=" + iq +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Head head = (Head) o;

        return getIq() != null ? getIq().equals(head.getIq()) : head.getIq() == null;
    }

    @Override
    public int hashCode() {
        return getIq() != null ? getIq().hashCode() : 0;
    }

    public Integer getIq() {
        return iq;
    }

    public void setIq(Integer iq) {
        this.iq = iq;
    }
}
