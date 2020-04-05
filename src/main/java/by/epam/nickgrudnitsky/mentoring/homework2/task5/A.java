package by.epam.nickgrudnitsky.mentoring.homework2.task5;

import java.util.Arrays;

public class A {
    private String alphabetName;
    private char[] alphabetArray;
    private int currentLetterPosition = 0;
    private char currentLetter = 'A';

    public A(String alphabetName, char[] alphabetArray) {
        this.alphabetName = alphabetName;
        this.alphabetArray = alphabetArray;
        currentLetter = alphabetArray[0];
    }

    public A() {
        alphabetName = "English alphabet";
        alphabetArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    }

    public boolean hasNext() {
        return currentLetterPosition == alphabetArray.length;
    }

    public char nextLetter() {
        return alphabetArray[++currentLetterPosition];
    }

    public int countAlphabetLetterAmount() {
        return alphabetArray.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        if (getCurrentLetterPosition() != a.getCurrentLetterPosition()) return false;
        if (getCurrentLetter() != a.getCurrentLetter()) return false;
        if (getAlphabetName() != null ? !getAlphabetName().equals(a.getAlphabetName()) : a.getAlphabetName() != null)
            return false;
        return Arrays.equals(getAlphabetArray(), a.getAlphabetArray());
    }

    @Override
    public int hashCode() {
        int result = getAlphabetName() != null ? getAlphabetName().hashCode() : 0;
        result = 31 * result + Arrays.hashCode(getAlphabetArray());
        result = 31 * result + getCurrentLetterPosition();
        result = 31 * result + (int) getCurrentLetter();
        return result;
    }

    @Override
    public String toString() {
        return "A{" +
                "alphabetName='" + alphabetName + '\'' +
                ", alphabetArray=" + Arrays.toString(alphabetArray) +
                ", letterPosition=" + currentLetterPosition +
                ", currentLetter=" + currentLetter +
                '}';
    }

    public String getAlphabetName() {
        return alphabetName;
    }

    public void setAlphabetName(String alphabetName) {
        this.alphabetName = alphabetName;
    }

    public char[] getAlphabetArray() {
        return alphabetArray;
    }

    public void setAlphabetArray(char[] alphabetArray) {
        this.alphabetArray = alphabetArray;
    }

    public int getCurrentLetterPosition() {
        return currentLetterPosition;
    }

    public void setCurrentLetterPosition(int currentLetterPosition) {
        this.currentLetterPosition = currentLetterPosition;
    }

    public char getCurrentLetter() {
        return currentLetter;
    }

    public void setCurrentLetter(char currentLetter) {
        this.currentLetter = currentLetter;
    }
}
