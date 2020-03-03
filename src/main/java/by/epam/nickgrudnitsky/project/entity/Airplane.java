package by.epam.nickgrudnitsky.project.entity;

import java.util.Objects;

public abstract class Airplane extends Vehicle {
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
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
