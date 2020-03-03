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
