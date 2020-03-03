package by.epam.nickgrudnitsky.project.entity;

public abstract class Ship extends Vehicle {
    private double speed;
    private double cruisingRange;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCruisingRange() {
        return cruisingRange;
    }

    public void setCruisingRange(double cruisingRange) {
        this.cruisingRange = cruisingRange;
    }

    // TODO: 3/3/20
    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
