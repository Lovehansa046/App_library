package Managers;

import entity.Book;

import java.io.*;

public class DataManager {
    private final String BOOK_FILE = "files/MyBooks.txt";

    public DataManager(){
        File file = new File("files");
        file.mkdirs();
    }

    public void saveBooks(Book[] books) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(BOOK_FILE );
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        }
    }
    public Book[] loadBooks() {
        Book[] books = new Book[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(BOOK_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books = (Book[]) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс");
        }
        return books;
    }


}

