package by.epam.nickgrudnitsky.mentoring.homework1.task5to7.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value= RUNTIME)
@Repeatable(ThisCodeSmellsContainer.class)
public @interface ThisCodeSmells {
    String reviewer();
}
