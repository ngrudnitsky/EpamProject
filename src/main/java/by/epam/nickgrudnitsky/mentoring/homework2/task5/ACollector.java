package by.epam.nickgrudnitsky.mentoring.homework2.task5;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ACollector implements Collector<A, List<String>, String> {
    @Override
    public Supplier<List<String>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<String>, A> accumulator() {
        return (l, e) -> l.add(e.getAlphabetName()
                .concat(": ").concat(Arrays.toString(e.getAlphabetArray())).concat("\n"));
    }

    @Override
    public BinaryOperator<List<String>> combiner() {
        return (e1, e2) -> Stream.of(e1, e2).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public Function<List<String>, String> finisher() {
        return e -> e.stream().reduce(String::concat).orElse("");
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.UNORDERED);
    }
}
