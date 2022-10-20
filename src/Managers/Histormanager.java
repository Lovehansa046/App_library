package Managers;

import entity.Book;
import entity.History;
import entity.Reader;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Histormanager {
    private Scanner scanner;
    private ReaderManager readerManager;
    private BookManager bookManager;

    public void HistoryManager() {
        scanner = new Scanner(System.in);
        readerManager = new ReaderManager();
        bookManager = new BookManager();
    }

    public History takeOnBook(Reader[] readers, Book[] books){
        System.out.println("Список читателей: ");
        readerManager.printListReaders(readers);
        System.out.print("Выберите номер читателя из списка: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();

        System.out.println("Список книг: ");
        bookManager.printListBooks(books);
        System.out.print("Выберите номер книги из списка: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        History history = new History();
        history.setBook(books[numberBook - 1]);
        history.setReader(readers[numberReader - 1]);
        history.setTakeOnBook(new GregorianCalendar().getTime());
        return history;
    }

    public void printListReadingBooks(History[] histories) {
        for (int i = 0; i < histories.length; i++) {
            if (histories[i].getReturnBook() == null) {
                System.out.print(i + 1 + ". " + histories[i].getBook().getBookName() + ". ");
                for (int j = 0; j < histories[i].getBook().getAuthors().length; j++) {
                    System.out.printf("%s %s %d",
                            histories[i].getBook().getAuthors()[j].getFirstname(),
                            histories[i].getBook().getAuthors()[j].getLastname(),
                            histories[i].getBook().getAuthors()[j].getBirthday());

                }
                System.out.println();
            }
        }
    }

    public void returnBook(History[] histories) {
        System.out.println("Список выданных книг: ");
        this.printListReadingBooks(histories);
        System.out.println("Выберите номер возвращаемой книги из списка: ");
        int numberHistory = scanner.nextInt(); scanner.nextLine();
        histories[numberHistory - 1].setReturnBook(new GregorianCalendar().getTime());
    }
}