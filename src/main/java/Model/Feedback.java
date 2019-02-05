package Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Feedback {
    private int id;
    private String username;
    private String message;
    private Date date;
    private int stars;

    // Constructor for customer when feedback is created
    public Feedback(String username, String message, int stars) {
        this.username = username;
        this.message = message;
        this.stars = stars;
        this.date = Date.from(LocalDate
                .now()
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant());
    }

    // Constroctor for FeedbackDAO, when importing from database, when date of creation is already known
    public Feedback(int id, String username, String message, Date date, int stars) {
        this.id = id;
        this.username = username;
        this.message = message;
        this.date = date;
        this.stars = stars;
    }
}
