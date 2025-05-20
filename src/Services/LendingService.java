package Services;
import models.Book;
import models.Patron;

import java.util.logging.Logger;


public class LendingService {
    private final Logger logger = Logger.getLogger(LendingService.class.getName());

    public void checkoutBook(Patron patron, Book book) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            patron.addBorrowedBook(book);
            logger.info(patron + " checked out " + book);
        } else {
            logger.warning("Book is already borrowed: " + book);
        }
    }

    public void returnBook(Book book) {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            logger.info("Returned book: " + book);
        }
    }
}
