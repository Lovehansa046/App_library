package entity;

import java.util.Date;

public class History {
    Book book;
    Reeter reeter;
    Date takeOnBook;
    Date returnBook;

    public History() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reeter getReeter() {
        return reeter;
    }

    public void setReeter(Reeter reeter) {
        this.reeter = reeter;
    }

    public Date getTakeOnBook() {
        return takeOnBook;
    }

    public void setTakeOnBook(Date takeOnBook) {
        this.takeOnBook = takeOnBook;
    }

    public Date getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Date returnBook) {
        this.returnBook = returnBook;
    }

    @Override
    public String toString() {
        return "History{" +
                "book=" + book +
                ", reeter=" + reeter +
                ", takeOnBook=" + takeOnBook +
                ", returnBook=" + returnBook +
                '}';
    }
}

