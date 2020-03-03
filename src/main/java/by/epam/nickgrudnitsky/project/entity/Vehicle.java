package by.epam.nickgrudnitsky.project.entity;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {
    private String id;
    private String mark;
    private String model;
    private double weight;
    private double carryingCapacity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (Double.compare(vehicle.getWeight(), getWeight()) != 0) return false;
        if (Double.compare(vehicle.getCarryingCapacity(), getCarryingCapacity()) != 0) return false;
        if (getId() != null ? !getId().equals(vehicle.getId()) : vehicle.getId() != null) return false;
        if (getMark() != null ? !getMark().equals(vehicle.getMark()) : vehicle.getMark() != null) return false;
        return getModel() != null ? getModel().equals(vehicle.getModel()) : vehicle.getModel() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getMark() != null ? getMark().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCarryingCapacity());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
