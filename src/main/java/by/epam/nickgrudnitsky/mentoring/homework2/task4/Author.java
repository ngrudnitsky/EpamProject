package by.epam.nickgrudnitsky.mentoring.homework2.task4;

import java.util.List;

@SuppressWarnings("unused")
public class Author {
    private String name;
    private short age;
    List<Book> books;

    public Author(String name, short age, List<Book> books) {
        this.name = name;
        this.age = age;
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (getAge() != author.getAge()) return false;
        if (getName() != null ? !getName().equals(author.getName()) : author.getName() != null) return false;
        return getBooks() != null ? getBooks().equals(author.getBooks()) : author.getBooks() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (int) getAge();
        if (getBooks() != null) {
            for (Book book : getBooks()) {
                result = 31 * result + book.getTitle().hashCode();
                result = 31 * result + book.getNumberOfPages();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Author: " + name + ", " + age + " ears ");
        for (int i = 0; i < books.size(); i++) {
            result.append(books.get(i).getTitle());
            if (i < books.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
