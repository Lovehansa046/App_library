package entity;

import java.util.Arrays;

public class Book {
    String bookName;
    Author[] authors;
    int publishedYear;
    int quantity;

    public  Book() {
        authors = new Author[0];
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        Author[] newAuthors = Arrays.copyOf(authors, authors.length+1); //Скопировать autrhors в newAuthors, где на одну ячейку больше
        newAuthors[newAuthors.length-1] = author; //Добавить в эту ячейку author из параметра метода
        authors = newAuthors; //Скопировать ссылку newAuthors в authors
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", publishedYear=" + publishedYear +
                ", quantity=" + quantity +
                '}';
    }
}
