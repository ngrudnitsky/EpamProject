package by.epam.nickgrudnitsky.mentoring.homework2.task5;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        A englishAlphabet = new A();
        A frenchAlphabet = new A();
        frenchAlphabet.setAlphabetName("French alphabet");
        A germanAlphabet = new A();
        germanAlphabet.setAlphabetName("German alphabet");
        A spanishAlphabet = new A("Spanish alphabet",
                new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                        'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'});

        List<A> alphabets = Arrays.asList(englishAlphabet, frenchAlphabet, germanAlphabet, spanishAlphabet,
                englishAlphabet, frenchAlphabet, germanAlphabet, spanishAlphabet,
                englishAlphabet, frenchAlphabet, germanAlphabet, spanishAlphabet,
                englishAlphabet, frenchAlphabet, germanAlphabet, spanishAlphabet,
                englishAlphabet, frenchAlphabet, germanAlphabet, spanishAlphabet);


        String collectedAlphabets = alphabets.parallelStream()
                .collect(new ACollector());

        System.out.println(collectedAlphabets);

    }
}
