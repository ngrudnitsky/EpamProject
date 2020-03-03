package by.epam.nickgrudnitsky.project.entity;

public abstract class Auto extends Vehicle {
    private String typeOfDrive;
    private double engineCapacity;

    public String getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(String typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Auto auto = (Auto) o;

        if (Double.compare(auto.getEngineCapacity(), getEngineCapacity()) != 0) return false;
        return getTypeOfDrive() != null ? getTypeOfDrive().equals(auto.getTypeOfDrive()) : auto.getTypeOfDrive() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (getTypeOfDrive() != null ? getTypeOfDrive().hashCode() : 0);
        temp = Double.doubleToLongBits(getEngineCapacity());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
