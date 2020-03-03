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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Ship ship = (Ship) o;

        if (Double.compare(ship.getSpeed(), getSpeed()) != 0) return false;
        return Double.compare(ship.getCruisingRange(), getCruisingRange()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getSpeed());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCruisingRange());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
