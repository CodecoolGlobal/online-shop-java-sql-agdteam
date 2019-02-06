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

    // Constructor for FeedbackDAO, when importing from database, when date of creation is already known
    public Feedback(int id, String username, String message, Date date, int stars) {
        this.id = id;
        this.username = username;
        this.message = message;
        this.date = date;
        this.stars = stars;
    }

    // Getters & Setters
	public int getId() { return id; }
	public String getUsername() { return username; }
	public void setUsername(String userName) { this.username = userName; }
	public Date getDate() {	return date; }
	public void setDate(Date date) { this.date = date; }
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	public int getStars() {	return stars; }
	public void setStars(int stars) { this.stars = stars; }
}
