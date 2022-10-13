package Library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reeter;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        Book book = null;
        Reeter reeter = null;
        History history = null;
        do{
            System.out.println("Задачи: ");
            System.out.println("0 - Закончить программу");
            System.out.println("1 - Добавить книгу");
            System.out.println("2 - Добавить Читателя");
            System.out.println("3 - Выдать Книгу");
            System.out.println("4 - Вернуть книгу");
            System.out.println("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1 - Добавить книгу");
                    book = createBook("Война и мир", 3, 1956);
                    book.addAuthor(createAuthor("Лев", "Толстой", 1828));
                    System.out.println(book);
                    break;
                case 2:
                    System.out.println("2 - Добавить Читателя");
                    reeter = new Reeter();
                    reeter.setFirstname("Иван");
                    reeter.setLastname("Иванов");
                    reeter.setPhone("55548356");
                    System.out.println(reeter);
                    break;
                case 3:
                    System.out.println("3 - Выдать Книгу");
                    history = new History();
                    history.setBook(book);
                    history.setReeter(reeter);
                    history.setTakeOnBook(new GregorianCalendar().getTime());
                    System.out.println(history);
                    break;
                case 4:
                    System.out.println("4 - Вернуть книгу");
                    history.setReturnBook(new GregorianCalendar().getTime());
                    System.out.println(history);
                case 5:
                    System.out.println("5 - ");

                    /////// о книге начало записи
                    System.out.println("Введите название книги: ");
                    String bookname = scanner.nextLine();
                    System.out.println("Введите количество книг: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Введите год издания книги: ");
                    int year = scanner.nextInt();
                    ////// о книги концовка записи

                    ////// о авторе начало записи
                     System.out.println("Введите имя автора ");
                    String authorname = scanner.nextLine();
                    System.out.println("Введите фамилию автора: ");
                    String authorlastname = scanner.nextLine();
                    System.out.println("Введите год рождения автора: ");
                    int birthday = scanner.nextInt();
                    ////// о авторе конец записи

                    book = createBook(bookname, quantity, year);

                    book.addAuthor(createAuthor(authorname, authorlastname, birthday));

                    System.out.println(book);


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
