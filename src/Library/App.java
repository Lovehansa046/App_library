package Library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import managers.BookManager;
import managers.HistoryManager;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class App {
    private Book[] books;
    private Reader[] readers;
    private History[] histories;
    private BookManager bookManager;
    private HistoryManager historyManager;

    public App() {
        this.books = new Book[0];
        this.readers = new Reader[0];
        this.histories = new History[0];
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;


        do{
            System.out.println(" ");
            System.out.println("Задачи: ");
            System.out.println("0. Закончить программу");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("5. Список выданных книг");
            System.out.println("6. Вывод всех книг");
            System.out.println("7. Вывод всех читателей");
            System.out.println("8. Редактирование книги");
            System.out.println("9. Список выданных книг");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. Добавить книгу");
                    System.out.println("Введите название книги: ");
                    String bookName = scanner.nextLine();
                    System.out.println("Введите год издания книги:");
                    String publishedYear = scanner.nextLine();
                    System.out.println("Введите колл-во экземпляров:");
                    String quantity = scanner.nextLine();

                    Book book = createBook(bookName, new Integer(quantity), Integer.parseInt(publishedYear));
                    System.out.println("Введите колл-во авторов книги: ");
                    int countAuthorsInBook = scanner.nextInt();scanner.nextLine();

                    for (int i = 0; i<countAuthorsInBook; i++){
                        System.out.println("Введите имя автора: "+(i+1)+": ");
                        String firstname = scanner.nextLine();
                        System.out.println("Введите фамилию автора: "+(i+1)+": ");
                        String lastname = scanner.nextLine();
                        System.out.println("Введите дату рождения автора: "+(i+1)+": ");
                        String birthday = scanner.nextLine();
                        book.addAuthor(createAuthor(firstname, lastname, Integer.parseInt(birthday)));
                    }
                    Book[] newBooks = new Book[books.length+1];
                    newBooks[newBooks.length-1] = book;
                    this.books = newBooks;
                    break;
                case 2:
                    System.out.println("2. Добавить читателя");
                    System.out.println("Введите имя читателя: ");
                    String readerName = scanner.nextLine();
                    System.out.println("Введите фамилию читателя:");
                    String readerLastName = scanner.nextLine();
                    System.out.println("Введите номер телефона читателя:");
                    String phoneNumber = scanner.nextLine();
                    Reader reader = new Reader();
                    reader.setFirstname(readerName);
                    reader.setLastname(readerLastName);
                    reader.setPhone(phoneNumber);
                    this.readers = Arrays.copyOf(this.readers, this.readers.length+1);
                    this.readers[this.readers.length - 1] = reader;
                    break;

                case 3:
                    System.out.println("3. Выдать книгу");
                    for (int i=0; i<readers.length; i++){
                        System.out.printf(i+1+". "+readers[i].getFirstname()+" "+readers[i].getLastname()+". ");
                    }
                    System.out.print("Выбери читателя: ");
                    int numberReader = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Список книг: ");
                    for( int i=0; i<books.length; i++){
                        System.out.println(i+1+". "+books[i].getBookName()+". "+books[i]+". ");
                        for (int j = 0; j<books[i].getAuthors().length; j++){
                            System.out.printf("%s %s %d",
                                    books[i].getAuthors()[j].getFirstname(),
                                    books[i].getAuthors()[j].getLastname(),
                                    books[i].getAuthors()[j].getBirthday());
                        }
                        System.out.println();
                    }
                    System.out.print("Выберите номер книги: ");
                    int numberBook = scanner.nextInt();scanner.nextLine();
                    History history = new History();
                    history.setBook(books[numberBook - 1]);
                    history.setReader(readers[numberReader - 1]);
                    history.setTakeOnBook(new GregorianCalendar().getTime());
                    History[] newHistories = new History[this.histories.length+1];
                    newHistories[newHistories.length-1]=history;
                    this.histories = newHistories;
                    System.out.println(history);
                    break;
                case 4:
                    System.out.println("4. Вернуть книгу");
//                    history.setReturnBook(new GregorianCalendar().getTime());
//                    System.out.println(history);
                    break;
                case 5:
                    System.out.println("5. Список выданных книг");
                    for (int i=0; i<histories.length; i++){
                        System.out.print(i+1+". "+histories[i].getBook().getBookName());
                        System.out.println(" ");
                    }
                    break;
                case 6:
                    System.out.println("6. Список всех книги");
                    for (int i=0; i<books.length; i++){
                        System.out.println(i+1+". "+books[i]);
                    }
                    break;
                case 7:
                    System.out.println("7. Список всех читателей");
                    for (int i=0; i<readers.length; i++){
                        System.out.println(i+1+". "+readers[i]);
                    }
                    break;
                case 8:
                    System.out.println("8. Редактирование книги");
                    books = bookManager.changeBook(books);
                    break;
                case 9:
                    System.out.println("9. Список выданных книг");
                    historyManager.printListTakeOnBooks(this.histories);
                    break;
                default:
                    System.out.println("Выберите задачу из списка!");;
            }
        }while(repeat);
        System.out.println("Закрытие программы, досвидания!");
    }
    public Book createBook(String bookName,int quantity, int publishedYear){
        Book book = new Book();
        book.setBookName(bookName);
        book.setPublishedYear(publishedYear);
        book.setQuantity(quantity);
        return book;
    }
    public Author createAuthor(String firstname, String lastname, int birthday){
        Author author = new Author();
        author.setBirthday(birthday);
        author.setFirstname(firstname);
        author.setLastname(lastname);
        return author;
    }
}