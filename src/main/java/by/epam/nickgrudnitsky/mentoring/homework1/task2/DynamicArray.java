package by.epam.nickgrudnitsky.mentoring.homework1.task2;

public class DynamicArray<T> {
    private T[] array;
    private int capacity = 0;
    private int size = 0;
    private Class<T> type;

    public DynamicArray(Class<T> type) {
        this.type = type;
        array = createNewArray(capacity);
    }

    public DynamicArray(Class<T> type, int capacity) {
        this.type = type;
        array = createNewArray(capacity);
    }

    private void ensureCapacity(int increaseBy) {
        T[] newArray = createNewArray(capacity + increaseBy);
        System.arraycopy(array, 0, newArray, 0, capacity);
        array = newArray;
        capacity += increaseBy;
    }

    public void add(T element) {
        if (size == capacity) {
            ensureCapacity(1);
        }
        array[size++] = element;
    }

    public T get(int index) {
        if (index < size && index > -1) {
            return array[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void remove(int index) {
        if (index < size && index >= 0) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
        }
    }

    private T[] createNewArray(int capacity) {
        return (T[]) java.lang.reflect.Array.newInstance(type, capacity);
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
