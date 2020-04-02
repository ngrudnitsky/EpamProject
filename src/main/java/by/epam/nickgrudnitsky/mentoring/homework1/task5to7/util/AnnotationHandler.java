package by.epam.nickgrudnitsky.mentoring.homework1.task5to7.util;

import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.annotation.ThisCodeSmells;
import by.epam.nickgrudnitsky.mentoring.homework1.task5to7.entity.problem.MontyHallProblem;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class AnnotationHandler {
    Map<String, Integer> reviewers = new HashMap<>();
    List<String> smeltCodeNames = new ArrayList<>();

    public static void main(String[] args) {
        AnnotationHandler handler = new AnnotationHandler();
        System.out.println(handler.getAllSmeltCodeNames(new MontyHallProblem()));
        System.out.println(handler.getAnnotationStatistics(new MontyHallProblem()));
    }

    public <T> List<String> getAllSmeltCodeNames(T object){
        smeltCodeNames.clear();
        reviewers.clear();
        handleAnnotation(object);
        return smeltCodeNames;
    }

    public <T> Map<String, Integer> getAnnotationStatistics(T object){
        smeltCodeNames.clear();
        reviewers.clear();
        handleAnnotation(object);
        return reviewers;
    }

    private  <T> void handleAnnotation(T object) {
        findClassAnnotations(object);
        findFieldsAnnotations(object);
        getMethodsAnnotations(object);
    }

    private <T> void getMethodsAnnotations(T object) {
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(ThisCodeSmells.class)) {
                ThisCodeSmells annotation = method.getAnnotation(ThisCodeSmells.class);
                addReviewer(annotation.reviewer());
                smeltCodeNames.add("Method: " + method.getName());
            }
        }
    }

    private <T> void findFieldsAnnotations(T object) {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(ThisCodeSmells.class)) {
                ThisCodeSmells annotation = field.getAnnotation(ThisCodeSmells.class);
                addReviewer(annotation.reviewer());
                smeltCodeNames.add("Field: " + field.getName());
            }
        }
    }

    private <T> void findClassAnnotations(T object) {
        if (object.getClass().isAnnotationPresent(ThisCodeSmells.class)) {
            ThisCodeSmells annotation = object.getClass().getAnnotation(ThisCodeSmells.class);
            addReviewer(annotation.reviewer());
            smeltCodeNames.add("Class: " + object.getClass().getName());
        }
    }

    private void addReviewer(String reviewer) {
        if (reviewers.containsKey(reviewer)) {
            Integer reviewerCount = reviewers.get(reviewer);
            reviewers.put(reviewer, ++reviewerCount);
            return;
        }
        reviewers.put(reviewer, 1);
    }
}
