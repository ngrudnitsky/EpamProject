package by.epam.nickgrudnitsky.mentoring.homework2.task2;

@FunctionalInterface
public interface CustomFunctionalInterface<T>  {
    T apply(T t);

    default String getInterfaceName(){
        return "I.m a custom functional interface from default method!";
    }

    static String getStaticValue(){
        return "I.m a custom functional interface from static method!";
    }
}
