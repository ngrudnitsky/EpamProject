package by.epam.nickgrudnitsky.mentoring.homework1.task5to7.annotation;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value= RUNTIME)
public @interface ThisCodeSmellsContainer {
    ThisCodeSmells[] value();
}
