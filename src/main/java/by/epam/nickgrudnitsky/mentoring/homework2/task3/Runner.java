package by.epam.nickgrudnitsky.mentoring.homework2.task3;

public class Runner {
    public static void main(String[] args) {
        ThreeFunction<Double, Double, Character, String> calculatorFunction = (d1, d2, c) -> {
            String template = String.format("%.2f %s %.2f = ", d1, c, d2);

            if (d2 == 0) return String.format("Division by 0: %.2f %s %.2f", d1, c, d2);
            switch (c) {
                case '*': {
                    return template + d1 * d2;
                }
                case '+': {
                    return template + (d1 + d2);
                }
                case '/': {
                    return template + d1 / d2;
                }
                case '-': {
                    return template + (d1 - d2);
                }
                default: {
                    return String.format("Invalid operation: %s", c);
                }
            }
        };

        ThreeFunction<Double, Double, Double, String> volumeFunction =
                (d1, d2, d3) -> String.format("The volume is %.3f", d1*d2*d3);

        System.out.println(calculatorFunction.apply(2., 2.5, '*'));
        System.out.println(calculatorFunction.apply(4.2, 0., '/'));
        System.out.println(calculatorFunction.apply(7.1, 2.9, '+'));
        System.out.println(calculatorFunction.apply(7.1, 2.9, 't'));

        System.out.println(volumeFunction.apply(2.25, 1.15, 5.));
    }
}
