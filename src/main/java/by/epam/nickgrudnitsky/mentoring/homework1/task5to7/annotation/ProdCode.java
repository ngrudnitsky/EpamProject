package by.epam.nickgrudnitsky.mentoring.homework1.task5to7.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value= ElementType.METHOD)
@Retention(value= RUNTIME)
public @interface ProdCode {
}
