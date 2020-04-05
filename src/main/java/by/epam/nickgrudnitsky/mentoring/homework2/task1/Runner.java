package by.epam.nickgrudnitsky.mentoring.homework2.task1;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class Runner {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Nick", 22),
                new Person("Bob", 19),
                new Person("Tom", 30),
                new Person("John", 37),
                new Person("Roger", 26)
        );

        System.out.println("Sorted by name:");
        people
                .stream()
                .sorted(comparing(Person::getName))
                .forEach(System.out::println);

        System.out.println("Sorted by age:");
        people
                .stream()
                .sorted(comparing(Person::getAge))
                .forEach(System.out::println);
    }
}
