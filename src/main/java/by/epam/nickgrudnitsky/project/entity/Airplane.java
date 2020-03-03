package by.epam.nickgrudnitsky.project.entity;

public abstract class Airplane extends Vehicle {
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Airplane airplane = (Airplane) o;

        return Double.compare(airplane.getSpeed(), getSpeed()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getSpeed());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
