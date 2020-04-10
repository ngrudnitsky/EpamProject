package by.epam.nickgrudnitsky.mentoring.homework1.task2;

public class Runner {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(Integer.class);
        dynamicArray.add(1);
        System.out.println(dynamicArray);
        dynamicArray.add(2);
        System.out.println(dynamicArray);
        dynamicArray.add(3);
        System.out.println(dynamicArray);
        dynamicArray.add(4);
        System.out.println(dynamicArray);
        dynamicArray.add(5);
        System.out.println(dynamicArray);
        dynamicArray.remove(4);
        System.out.println(dynamicArray);
        dynamicArray.remove(0);
        System.out.println(dynamicArray);
        dynamicArray.remove(0);
        System.out.println(dynamicArray);
        dynamicArray.remove(0);
        System.out.println(dynamicArray);
        dynamicArray.remove(0);
        System.out.println(dynamicArray);
        dynamicArray.remove(0);
        System.out.println(dynamicArray);
    }
}
