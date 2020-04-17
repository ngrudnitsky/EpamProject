package by.ngrudnitsky.mentoring.homework3.examples.service;


import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SPELSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Please uppercase me'.toUpperCase()");
        System.out.println(expression.getValue());
    }
}
