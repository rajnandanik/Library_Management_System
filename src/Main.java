import Factories.BookFactory;
import models.Book;
import models.Patron;
import Observers.InventoryNotifier;
import Services.BookService;
import Services.LendingService;
import Services.PatronService;
import Utils.LoggerUtil;

public class Main {
    public static void main(String[] args) {
        LoggerUtil.configureLogger();

        InventoryNotifier notifier = new InventoryNotifier();
        BookService bookService = new BookService(notifier);
        PatronService patronService = new PatronService();
        LendingService lendingService = new LendingService();

        // Add books
        Book book1 = BookFactory.createBook("Clean Code", "Robert C. Martin", "123", 2008);
        bookService.addBook(book1);

        // Add patron
        Patron patron1 = new Patron("Nandani", "P001");
        patronService.addPatron(patron1);

        // Checkout book
        lendingService.checkoutBook(patron1, book1);

        // Return book
        lendingService.returnBook(book1);
    }
}
