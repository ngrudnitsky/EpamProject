package by.epam.nickgrudnitsky.mentoring.homework1.task2;

public class DynamicArray<T> {
    private T[] array;
    private int capacity = 1;
    private int size = 0;
    private Class<T> type;

    public DynamicArray(Class<T> type) {
        array = createNewArray(capacity);
        this.type = type;
    }

    public DynamicArray(Class<T> type, int capacity) {
        this.capacity = capacity;
        this.type = type;
        array = createNewArray(capacity);
    }

    public void add(T element) {
        if (size == capacity) {
            capacity = array.length + 1;
            T[] newArray = createNewArray(capacity);
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
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
        T[] newArray = createNewArray(array.length - 1);
        if (array.length - 1 >= index) {
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        }
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        array = newArray;
        size--;
    }

    private T[] createNewArray(int capacity){
        return (T[]) java.lang.reflect.Array.newInstance(type, capacity);
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
