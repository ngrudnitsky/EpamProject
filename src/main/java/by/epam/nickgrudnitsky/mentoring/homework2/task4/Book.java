package by.epam.nickgrudnitsky.mentoring.homework2.task4;

import java.util.List;

@SuppressWarnings("unused")
public class Book {
    private String title;
    private List<Author> authors;
    private int numberOfPages;

    public Book(String title, List<Author> authors, int numberOfPages) {
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (getNumberOfPages() != book.getNumberOfPages()) return false;
        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
        return getAuthors() != null ? getAuthors().equals(book.getAuthors()) : book.getAuthors() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        if (getAuthors() != null) {
            for (Author author : getAuthors()) {
                result = 31 * result + author.getName().hashCode();
                result = 31 * result + author.getAge();
            }
        }
        result = 31 * result + getNumberOfPages();
        return result;
    }

    @Override
    public String
    toString() {
        StringBuilder result = new StringBuilder("Book: " + title + " ");
        for (Author author : authors) {
            result.append(author.getName());
        }
        return result + ", " + numberOfPages + " pages";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
