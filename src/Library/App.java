package Library;

import Managers.BookManager;
import Managers.Histormanager;
import Managers.ReaderManager;
import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class App {
    private final Scanner scanner;
    private Book[] books;
    private Reader[] readers;
    private History[] histories;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private final Histormanager histormanager;

    public App() {
        scanner = new Scanner(System.in);
        books = new Book[0];
        readers = new Reader[0];
        histories = new History[0];
        bookManager = new BookManager();
        readerManager = new ReaderManager();
        histormanager = new Histormanager();
    }

    public void run() {
        boolean repeat = true;

        History history = null;
        do {
            System.out.println("Задачи: ");
            System.out.println("0. Закончить программу");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("5. Список выданных книг");
            System.out.println("6. Список книг");
            System.out.println("7. Список читателей");
            System.out.println("8. Редактировать книгу");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. Добавить книгу");
                    addBook(bookManager.createBookWithAuthor());
                    break;
                case 2:
                    System.out.println("2. Добавить читателя");
                    addReader(readerManager.newReader());
                    break;
                case 3:
                    System.out.println("3. Выдать книгу");
                    addHistories(histormanager.takeOnBook(readers, books));
                    break;
                case 4:
                    System.out.println("4. Вернуть книгу");
                    histormanager.returnBook(histories);
                    break;
                case 5:
                    System.out.println("5. Список выданных книг");
                    histormanager.printListReadingBooks(histories);
                    break;
                case 6:
                    System.out.println("6. Список книг");
                    bookManager.printListBooks(books);
                    break;
                case 7:
                    System.out.println("7. Список читателей");
                    readerManager.printListReaders(readers);
                    break;
                case 8:
                    System.out.println("8. Редактировать книгу");
                    this.books = bookManager.changeBook(books);
                    break;
                default:
                    System.out.println("Выберите задачу из списка!");
                    ;
            }

        } while (repeat);
        System.out.println("Закрытие программы, досвидания!");
    }
    private void addBook(Book book){
        books = Arrays.copyOf(books, books.length+1);
        books[books.length-1] = book;
    }

    private void addReader(Reader reader) {
        readers = Arrays.copyOf(readers, readers.length + 1);
        readers[readers.length - 1] = reader;
    }
    private void addHistories(History history) {
        histories = Arrays.copyOf(histories, histories.length + 1);
        histories[histories.length - 1] = history;
    }
}