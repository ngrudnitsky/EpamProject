package by.epam.nickgrudnitsky.mentoring.homework2.task2;


import java.util.function.*;

public class Runner {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("1. I'm runnable!");;
        Thread thread = new Thread(runnable);
        thread.start();

        Supplier<String> supplier = () -> "2. I'm a supplier!";
        System.out.println(supplier.get());

        Consumer<String> consumer = System.out::println;
        consumer.accept("3. I'm a consumer!");

        Function<Integer, String> function = e -> e + ". I'm a function!";
        System.out.println(function.apply(4));

        BiFunction<Long, Integer, String> biFunction = (e1, e2) -> e1 + e2 + ". I'm a biFunction!";
        System.out.println(biFunction.apply(3L, 2));

        UnaryOperator<String> unaryOperator = e -> e + " I'm a unaryOperation!";
        System.out.println(unaryOperator.apply("6."));

        Predicate<String> predicate = e -> e.equals("7.");
        if (predicate.test("7.")) System.out.println("7. I'm a predicate!");

        CustomFunctionalInterface<String> customFunctionalInterface1 = new CustomFunctionalInterface<String>() {
            @Override
            public String apply(String s) {
                return s + this.getInterfaceName() +"\n   " + CustomFunctionalInterface.getStaticValue();
            }
        };
        System.out.println(customFunctionalInterface1.apply("8. "));

        CustomFunctionalInterface<String> customFunctionalInterface2 = String::toLowerCase;
        System.out.println(customFunctionalInterface2.apply("9. ") + customFunctionalInterface1.getInterfaceName() +
                "\n   " + CustomFunctionalInterface.getStaticValue());

    }
}
