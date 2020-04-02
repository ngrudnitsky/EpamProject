package by.epam.nickgrudnitsky.mentoring.homework1.task5to7.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;

@Target(value= ElementType.FIELD)
@Retention(value= SOURCE)
public @interface UseStackOnly {
}
