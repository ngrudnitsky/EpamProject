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
