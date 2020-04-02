package by.epam.nickgrudnitsky.mentoring.homework1.task5to7.util;

import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.annotation.ProdCode;
import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.entity.problem.MontyHallProblem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProdRunner {
    public static void main(String[] args) {
        ProdRunner runner = new ProdRunner();
        runner.invokeMethods(new MontyHallProblem());
    }

    public   <T> void invokeMethods(T object) {
        Method[] declaredMethods = object.getClass().getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(ProdCode.class)){
                declaredMethod.setAccessible(true);
                try {
                    declaredMethod.invoke(object);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
