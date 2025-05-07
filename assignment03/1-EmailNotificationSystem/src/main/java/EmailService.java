public class EmailService {
    public void sendEmail(String emailAddress, String message) {
        // Simulate sending email. In production, would call SMTP server or external API.
        System.out.println("Sending email to: " + emailAddress + " with message: " + message);
    }
}
