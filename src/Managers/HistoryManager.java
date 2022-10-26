package Managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class HistoryManager {

    public static int numberBook;

    public static int numberReturnBook;
        private final Scanner scanner;

        private Book[] books;

    public HistoryManager() {
            scanner = new Scanner(System.in);
        }

        public History takeOnBook(Book[] books, Reader[] readers){
            System.out.println("Список читателей: ");
            for (int i = 0; i < readers.length; i++) {
                System.out.println(i+1+". "+readers[i].getFirstname()+" "+readers[i].getLastname());
            }
            System.out.print("Выбери читателя: ");
            int numberReader = scanner.nextInt(); scanner.nextLine();
            System.out.println("Список книг: ");
            for (int i = 0; i < books.length; i++) {
                System.out.print(i+1+". "+books[i].getBookName());
                for (int j = 0; j < books[i].getAuthors().length; j++) {
                    System.out.printf("%s %s %d %d",
                            books[i].getAuthors()[j].getFirstname(),
                            books[i].getAuthors()[j].getLastname(),
                            books[i].getAuthors()[j].getBirthday(),
                            books[i].getQuantity());


                }
                System.out.println();
            }

            System.out.print("Выбери номер книги: ");
            numberBook = scanner.nextInt();scanner.nextLine();

            BookManager.QuantityMinusCount(books);

            History history = new History();
            history.setBook(books[numberBook - 1]);
            history.setReader(readers[numberReader-1]);
            history.setTakeOnBook(new GregorianCalendar().getTime());
            return history;
        }

        public void printReadingBooks(History[] histories){
            for (int i = 0; i < histories.length; i++) {
                if(histories[i].getReturnBook() == null){
                    System.out.print(i+1+". "+histories[i].getBook().getBookName()+". ");
                    for (int j = 0; j < histories[i].getBook().getAuthors().length; j++) {
                        System.out.printf("%s %s %d",
                                histories[i].getBook().getAuthors()[j].getFirstname(),
                                histories[i].getBook().getAuthors()[j].getLastname(),
                                histories[i].getBook().getAuthors()[j].getBirthday()
                        );
                    }
                    System.out.println();
                }
            }
        }

        public History[] returnBook(History[] histories) {
            //выбрать номер истории с возвращаемой книгой
            //вставить текущую дату в поле returnBook
            System.out.println("Список выданных книг: ");
            this.printReadingBooks(histories);
            System.out.print("Выберите из списка номер возвращаемой книги: ");
            numberReturnBook = scanner.nextInt();
            scanner.nextLine();
            BookManager.QuantityPlusCount(histories);
            histories[numberReturnBook - 1].setReturnBook(new GregorianCalendar().getTime());
            return histories;
        }
    }