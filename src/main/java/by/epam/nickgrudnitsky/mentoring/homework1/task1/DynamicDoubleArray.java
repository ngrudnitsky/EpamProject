package by.epam.nickgrudnitsky.mentoring.homework1.task1;

public class DynamicDoubleArray {
    private double[] array;
    private int capacity = 1;
    private int size = 0;

    public DynamicDoubleArray() {
        array = new double[1];
    }

    public DynamicDoubleArray(int capacity) {
        array = new double[capacity];
        this.capacity = capacity;
    }

    public void add(double element) {
        if (size == capacity) {
            capacity = array.length + 1;
            double[] newArray = new double[capacity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = element;
    }

    public double get(int index) {
        if (index < size && index > -1) {
            return array[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void remove(int index) {
        double[] newArray = new double[array.length - 1];

        if (array.length - 1 >= index) {
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        }
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i == size - 1){
                break;
            }
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
