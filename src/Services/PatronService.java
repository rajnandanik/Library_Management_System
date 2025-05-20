package Services;
import models.Patron;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class PatronService {
    private final Map<String, Patron> patrons = new HashMap<>();
    private final Logger logger = Logger.getLogger(PatronService.class.getName());

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
        logger.info("Added patron: " + patron);
    }

    public Patron getPatron(String id) {
        return patrons.get(id);
    }
}
