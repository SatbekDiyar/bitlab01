package bit.dikey;

import java.io.Serializable;
import java.util.ArrayList;

public class DataPackage implements Serializable {
    private String operationType;
    private ArrayList<Book> books;
    private Book book;

    public DataPackage() {
    }

    public DataPackage(String operationType, ArrayList<Book> books, Book book) {
        this.operationType = operationType;
        this.books = books;
        this.book = book;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "DataPackage{" +
                "operationType='" + operationType + '\'' +
                ", books=" + books +
                ", book=" + book +
                '}';
    }
}
