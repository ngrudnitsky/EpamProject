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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CargoShip cargoShip = (CargoShip) o;

        return getDecksNumber() == cargoShip.getDecksNumber();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getDecksNumber();
        return result;
    }
}
