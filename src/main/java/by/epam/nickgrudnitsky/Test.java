package by.epam.nickgrudnitsky;

import by.epam.nickgrudnitsky.mentoring.homework1.task2.DynamicArray;

public class Test {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>(Integer.class, 10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        System.out.println(array.get(0));
        System.out.println(array.get(1));
        System.out.println(array);
        array.remove(3);
        System.out.println(array);
        array.remove(0);
        System.out.println(array);
        array.remove(0);
        System.out.println(array);
        array.remove(0);
        System.out.println(array);
        array.remove(0);
        System.out.println(array);
    }
}
