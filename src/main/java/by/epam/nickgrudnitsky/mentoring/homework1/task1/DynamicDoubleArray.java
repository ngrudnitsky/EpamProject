package by.epam.nickgrudnitsky.mentoring.homework1.task1;

public class DynamicDoubleArray {
    private double[] array = new double[1];
    private int capacity = 0;
    private int size = 0;

    public DynamicDoubleArray() {

    }

    public DynamicDoubleArray(int capacity) {
        ensureCapacity(capacity);
    }

    public void add(double element) {
        if (size == capacity) {
            ensureCapacity(1);
        }
        array[size++] = element;
    }

    private void ensureCapacity(int increaseBy) {
        double[] newArray = new double[capacity + increaseBy];
        System.arraycopy(array, 0, newArray, 0, capacity);
        array = newArray;
        capacity += increaseBy;
    }

    public double get(int index) {
        if (index < size && index > -1) {
            return array[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void remove(int index) {
        if (index<size && index>=0) {
            for(int i=index;i<size-1;i++){
                array[i] = array[i+1];
            }
            array[size-1]=0;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i == size - 1) {
                break;
            }
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
