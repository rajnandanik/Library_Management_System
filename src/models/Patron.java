package models;
import java.util.ArrayList;
import java.util.List;


public class Patron {
    private String name;
    private String id;
    private List<Book> borrowingHistory = new ArrayList<>();

    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public List<Book> getBorrowingHistory() { return borrowingHistory; }

    public void addBorrowedBook(Book book) {
        borrowingHistory.add(book);
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
