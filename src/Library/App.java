package Library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reeter;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    private Book[] books;
    private Reeter[] reeters;
    private History[] histories;


    public App() {
        books = new Book[0];
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        Reeter reeter = null;
        History history = null;
        do{
            System.out.println("Задачи: ");
            System.out.println("0 - Закончить программу");
            System.out.println("1 - Добавить книгу");
            System.out.println("2 - Добавить Читателя");
            System.out.println("3 - Выдать Книгу");
            System.out.println("4 - Вернуть книгу");
            System.out.println("5 - Добавить книгу (ручное заполение)");
            System.out.println("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:

                    System.out.println("1 - Добавить книгу");

                    System.out.println("Введите название книги: ");
                    String bookname = scanner.nextLine();
                    System.out.println("Введите количество книг: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Введите год издания книги: ");
                    int year = scanner.nextInt();

                    Book book = createBook(bookname, quantity, year);

                    System.out.println("Введите количество авторов: ");
                    int countAuthors = scanner.nextInt(); scanner.nextLine();
                    for (int i = 0; i < countAuthors; i++) {
                        System.out.println("Введите имя автора " + (i + 1) + ":");
                        String authorname = scanner.nextLine();
                        System.out.println("Введите фамилию автора " + (i + 1) + ":");
                        String authorlastname = scanner.nextLine();
                        System.out.println("Введите год рождения автора " + (i + 1) + ":");
                        int birthday = scanner.nextInt();
                        book.addAuthor(createAuthor(authorname, authorlastname, birthday));

                    }
                    Book[] newBooks = new Book[books.length+1];
                    newBooks[newBooks.length-1] = book;
                    this.books = newBooks;
                    break;

//                    System.out.println("Введите имя автора ");
//                    String authorname = scanner.nextLine();
//                    System.out.println("Введите фамилию автора: ");
//                    String authorlastname = scanner.nextLine();
//                    System.out.println("Введите год рождения автора: ");
//                    int birthday = scanner.nextInt();




//                    book.addAuthor(createAuthor(authorname, authorlastname, birthday));


//                    book = createBook("Война и мир", 3, 1956);
//                    book.addAuthor(createAuthor("Лев", "Толстой", 1828));
//                    System.out.println(book);

                case 2:
                    System.out.println("2 - Добавить Читателя");
                    reeter = new Reeter();
                    System.out.println("Введите имя читателя: ");
                    String firstname = scanner.nextLine();
                    System.out.println("Введите фамилию читателя: ");
                    String lastname = scanner.nextLine();
                    System.out.println("Введите номер телефона читателя: ");
                    String phone = scanner.nextLine();
                    reeter.setFirstname(firstname);
                    reeter.setLastname(lastname);
                    reeter.setPhone(phone);
                    System.out.println(reeter);
                    break;
                case 3:
                    System.out.println("3 - Выдать Книгу");
                    System.out.println("Список читателей: ");
                    for (int i = 0; i < reeters.length; i++) {
                        System.out.printf(i+1+". "+reeters[i].getFirstname()+". "+reeters[i].getLastname());
                    }
                    System.out.print("Выбери читателя: ");
                    int NumberReader = scanner.nextInt(); scanner.nextLine();
                    for (int i = 0; i < books.length; i++) {
                        System.out.print(i+1+". "+books[i].getBookName()+". ");
                        for (int j = 0; j < books[i].getAuthors().length;j++) {
                            System.out.printf("%s %s %s",
                                    books[i].getAuthors()[j].getFirstname(),
                                    books[i].getAuthors()[j].getLastname(),
                                    books[i].getAuthors()[j].getBirthday());
                        }
                        System.out.println();
                    }
                    System.out.print("Выберите номер книги: ");
                    int NumberBook = scanner.nextInt(); scanner.nextLine();
                    history = new History();
                    history.setBook(books[NumberBook - 1]);
                    history.setReeter(reeters[NumberReader - 1]);
                    history.setTakeOnBook(new GregorianCalendar().getTime());
                    History[] newHistories = new History[this.histories.length+1];
                    newHistories[newHistories.length-1]=history;
                    this.histories = newHistories;
                    System.out.println(history);
                    break;
                case 4:
                    System.out.println("4 - Вернуть книгу");
                    history.setReturnBook(new GregorianCalendar().getTime());
                    System.out.println(history);

                case 5:
                    System.out.println("5 - Список Выданных Книг ");
                    for (int i = 0; i < histories.length; i++) {
                        System.out.print(i+1+". "+histories[i].getBook().getBookName());
                    }
                    break;
                default:
                    System.out.println("Выберите задачу из списка!");
            }
        }while(repeat);
        System.out.println("Закрытие программы, Досвидание ваше привосходительство!");
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
