package Services;
import models.Book;
import Observers.InventoryNotifier;

import java.util.*;
import java.util.logging.Logger;

public class BookService {
    private final Map<String, Book> inventory = new HashMap<>();
    private final InventoryNotifier notifier;
    private final Logger logger = Logger.getLogger(BookService.class.getName());

    public BookService(InventoryNotifier notifier) {
        this.notifier = notifier;
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        notifier.notifyObservers();
        logger.info("Added book: " + book);
    }

    public void removeBook(String isbn) {
        inventory.remove(isbn);
        notifier.notifyObservers();
        logger.info("Removed book with ISBN: " + isbn);
    }

    public Book searchByISBN(String isbn) {
        return inventory.get(isbn);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : inventory.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public Collection<Book> getAllBooks() {
        return inventory.values();
    }
}
