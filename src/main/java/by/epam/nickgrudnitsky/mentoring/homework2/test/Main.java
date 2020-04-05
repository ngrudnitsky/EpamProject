package by.epam.nickgrudnitsky.mentoring.homework2.test;

import by.epam.nickgrudnitsky.mentoring.homework2.test.beans.Department;
import by.epam.nickgrudnitsky.mentoring.homework2.test.beans.Employee;
import com.sun.corba.se.spi.orbutil.closure.Closure;

import java.util.*;
import java.util.function.BiFunction;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = hireEmployee();

        Map<String, Department> result = employees.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.toMap(Employee::getName, Employee::getDepartment));
        System.out.println(result);

        String delimitedNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("# "));
        System.out.println(delimitedNames);


        Map<Department, String> result2 = employees.stream()
                .collect(groupingBy(Employee::getDepartment, mapping(Employee::getSkill, joining(" &"))));
        System.out.println(result2);

        /*Map<String, Integer> backendSkillMatrix = new HashMap<>();
        backendSkillMatrix.put("Java", 4);
        backendSkillMatrix.put("Scala", 3);
        backendSkillMatrix.put("Kotlin", 1);
        Developer back = new Developer("Nick", backendSkillMatrix);

        Map<String, Integer> frontendSkillMatrix = new HashMap<>();
        backendSkillMatrix.put("React", 90);
        backendSkillMatrix.put("Angular", 80);
        backendSkillMatrix.put("Kotlin", 4);
        Developer front = new Developer("Vasya", frontendSkillMatrix);

        List<Developer> projectTeam = new ArrayList<>();
        projectTeam.add(back);
        projectTeam.add(front);

        List<String> result = projectTeam.stream()
                .map(e -> e.getSkillMatrix().entrySet())
                .flatMap(set -> set.stream())
                .peek(System.out::println)
                .filter(item -> item.getValue() > 2)
                .map(item -> item.getKey())
                .distinct()
                .collect(Collectors.toList());

        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println(ints.reduce(0, Integer::sum));
        System.out.println(ints.collect(summingInt(Integer::intValue)));*/


        /*CalculatePerDiem machine = new CalculatePerDiem();
        Function<Integer, Double> curriedFirstArgument = machine.curryFirstArgument(57.16);
        System.out.println(curriedFirstArgument.apply(5));
        System.out.println(curriedFirstArgument.apply(10));

        Function<Double, Double> curiedBySecondArgument = machine.currySecondArgument(10);
        System.out.println(curiedBySecondArgument.apply(56.12));*/


        /*List<Integer> fibonacciNumbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13);

        Function<Integer, Integer> addTwo = e -> e + 2;
        Function<Integer, Integer> multipleTen = e -> e * 10;

        fibonacciNumbers
                .stream()
                .map(addTwo.andThen(multipleTen))
                .forEach(System.out::println);

        fibonacciNumbers
                .stream()
                .map(addTwo.compose(multipleTen))
                .forEach(System.out::println);

        fibonacciNumbers
                .stream()
                .map(compose(addTwo, multipleTen))
                .forEach(System.out::println);*/

        /*Consumer<Department> printlnDepartment = System.out::println;
        Consumer<Boolean> printlnBoolean = System.out::println;
        Consumer<Double> printlnDouble = System.out::println;
        Consumer<String> printlnString = System.out::println;

        Function<String, Department> constructor2 =Department::new;

        Arrays.asList("Backend", "Frontend")
                .stream()
                .map(constructor2)
                .forEach(printlnDepartment);

        BiFunction<String, CharSequence, Boolean> contains = String::contains;

        printlnBoolean.accept(contains.apply("Belarus", "Belostok"));

        final DoubleUnaryOperator doubleUnary = Math::abs;
        printlnDouble.accept(doubleUnary.applyAsDouble(-3.33));

        Function<Department, String> getName = Department::getName;
        printlnString.accept(getName.apply(constructor2.apply("Mobile")));*/


    }

    private static Function<Integer, Integer> compose(Function<Integer, Integer> x, Function<Integer, Integer> y) {
        return result -> y.apply(x.apply(result));
    }


    private static List<Employee> hireEmployee() {
        Department backendDepartment = new Department("Backend department");
        Department financeDepartment = new Department("Finance department");

        return Arrays.asList(new Employee(19, "Nikita", "Java", 1, backendDepartment),
                new Employee(31, "Bob", ".NET", 3, backendDepartment),
                new Employee(34, "Arthur", "Delphi", 5, financeDepartment),
                new Employee(24, "Sam", "Java", 3, financeDepartment));
    }

}

@FunctionalInterface
interface CurriedBiFunction<T, U, R> extends BiFunction<T, U, R> {
    default Function<U, R> curryFirstArgument(T t) {
        return u -> apply(t, u);
    }

    default Function<T, R> currySecondArgument(U u) {
        return t -> apply(t, u);
    }
}

class CalculatePerDiem implements CurriedBiFunction<Double, Integer, Double> {
    private static final Double perDiemRate = 10.15;

    @Override
    public Double apply(Double dollarExchangeRate, Integer amountOfDay) {
        return dollarExchangeRate * amountOfDay * perDiemRate;
    }
}