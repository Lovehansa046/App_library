package Library;

import entity.Author;
import entity.Book;

public class App {
    public void run() {

    }

    public Book createBook(String bookName, int quantity, int publishedYear) {
        Book book = new Book();
        book.setBookName(bookName);
        book.setPublishedYear(publishedYear);
        book.setQuantity(quantity);
        return book;
    }

    public Author createAuthor(String firstname, String lastname, int birthday) {
        Author author = new Author();
        author.setFirstname(firstname);
        author.setBirthday(birthday);
        author.setLastname(lastname);
        return author;
    }
}
