package by.epam.nickgrudnitsky.project.entity;

public class CargoAirplane extends Airplane {
    private double cargoCompartmentVolume;
    private double rangeOfFlight;

    public double getCargoCompartmentVolume() {
        return cargoCompartmentVolume;
    }

    public void setCargoCompartmentVolume(double cargoCompartmentVolume) {
        this.cargoCompartmentVolume = cargoCompartmentVolume;
    }

    public double getRangeOfFlight() {
        return rangeOfFlight;
    }

    public void setRangeOfFlight(double rangeOfFlight) {
        this.rangeOfFlight = rangeOfFlight;
    }

    @Override
    public String toString() {
        return getMark() + " " + getModel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CargoAirplane airplane = (CargoAirplane) o;

        if (Double.compare(airplane.getCargoCompartmentVolume(), getCargoCompartmentVolume()) != 0) return false;
        return Double.compare(airplane.getRangeOfFlight(), getRangeOfFlight()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getCargoCompartmentVolume());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getRangeOfFlight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
