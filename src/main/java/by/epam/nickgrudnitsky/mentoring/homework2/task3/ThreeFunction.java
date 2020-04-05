package by.epam.nickgrudnitsky.mentoring.homework2.task3;

@FunctionalInterface
public interface ThreeFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
