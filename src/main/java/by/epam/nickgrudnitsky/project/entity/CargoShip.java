package by.epam.nickgrudnitsky.project.entity;

public class CargoShip extends Ship {
    private int decksNumber;

    public int getDecksNumber() {

        return decksNumber;
    }

    public void setDecksNumber(int decksNumber) {
        this.decksNumber = decksNumber;
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
