public class EmailNotificationSystem {
    private final EmailService emailService;

    public EmailNotificationSystem(EmailService emailService) {
        this.emailService = emailService;
    }

    // Send a single email
    public void notifyUser(String emailAddress, String message) {
        if (emailAddress == null || emailAddress.isEmpty()) {
            throw new IllegalArgumentException("Email address cannot be null or empty");
        }
        emailService.sendEmail(emailAddress, message);
    }
}
