package by.epam.nickgrudnitsky.project.entity;

public class Truck extends Auto {
    private int numberOfAxles;
    private String wheelFormula;
    private boolean openBodyType;
    private boolean trailer;

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    public String getWheelFormula() {
        return wheelFormula;
    }

    public void setWheelFormula(String wheelFormula) {
        this.wheelFormula = wheelFormula;
    }

    public boolean isOpenBodyType() {
        return openBodyType;
    }

    public void setOpenBodyType(boolean openBodyType) {
        this.openBodyType = openBodyType;
    }

    public boolean isTrailer() {
        return trailer;
    }

    public void setTrailer(boolean trailer) {
        this.trailer = trailer;
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

        Truck truck = (Truck) o;

        if (getNumberOfAxles() != truck.getNumberOfAxles()) return false;
        if (isOpenBodyType() != truck.isOpenBodyType()) return false;
        if (isTrailer() != truck.isTrailer()) return false;
        return getWheelFormula() != null ? getWheelFormula().equals(truck.getWheelFormula()) : truck.getWheelFormula() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNumberOfAxles();
        result = 31 * result + (getWheelFormula() != null ? getWheelFormula().hashCode() : 0);
        result = 31 * result + (isOpenBodyType() ? 1 : 0);
        result = 31 * result + (isTrailer() ? 1 : 0);
        return result;
    }
}
