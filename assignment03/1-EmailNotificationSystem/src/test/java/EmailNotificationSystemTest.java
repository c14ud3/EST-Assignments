
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmailNotificationSystemTest {
    private EmailService emailService;
    private EmailNotificationSystem notificationSystem;

    @BeforeEach
    void setup() {
        emailService = mock(EmailService.class); // mock the emailService dependency
        notificationSystem = new EmailNotificationSystem(emailService); // create new email notification system with the mocked dependency
    }

    @AfterEach
    void teardown() {
        emailService = null; // Clean up mocked email service
        notificationSystem = null; // Clean up the email notification system
    }

    // Task A tests
    @Test
    void notifyUser_validEmail_sendsEmail() {
        // Create some valid parameters
        String email = "user@example.com";
        String message = "Hello World!";

        // Call the notifyUser() method under test
        notificationSystem.notifyUser(email, message);

        // check that the emailService's sendEmail method is called exactly once
        verify(emailService, times(1)).sendEmail(email, message);
    }

    @Test
    void notifyUser_nullEmail_throwsException() {
        // Create invalid parameters with a null email
        String email = null;
        String message = "Hello";

        // Call the notifyUser() method under test and save the exception
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> notificationSystem.notifyUser(email, message)
        );

        // Assert if the exception message is as expected
        String expectedMessage = "Email address cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void notifyUser_emptyEmail_throwsException() {
        // Create invalid parameters with an empty email
        String email = "";
        String message = "Hello";

        // Call the notifyUser() method under test and save the exception
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> notificationSystem.notifyUser(email, message)
        );

        // Assert if the exception message is as expected
        String expectedMessage = "Email address cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    // Task B tests (TDD)
    @Test
    void notifyUsersBatch_validEmails_sendsEmails() {
        // Create some valid parameters
        List<String> emails = List.of("user1@example.com", "user2@example.com");
        String message = "Hello!";

        // Call the notifyUsersBatch() method under test
        notificationSystem.notifyUsersBatch(emails, message);

        // check that the emailService's sendEmail method is called for each email
        for (String email : emails) {
            verify(emailService, times(1)).sendEmail(email, message);
        }
    }

    @Test
    void notifyUsersBatch_oneValidEmail_sendsEmail() {
        // Create some valid parameters
        List<String> emails = List.of("user1@example.com");
        String message = "Hello!";

        // Call the notifyUsersBatch() method under test
        notificationSystem.notifyUsersBatch(emails, message);

        // check that the emailService's sendEmail method is called once
        verify(emailService, times(1)).sendEmail(emails.get(0), message);

    }

    @Test
    void notifyUsersBatch_noEmail_throwsException() {
        // Create some valid parameters
        List<String> emails = List.of();
        String message = "Hello!";

        // Call the notifyUsersBatch() method under test and save the exception
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> notificationSystem.notifyUsersBatch(emails, message)
        );

        // Assert if the exception message is as expected
        String expectedMessage = "Email list cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void notifyUsersBatch_nullList_throwsException() {
        // Create some valid parameters
        List<String> emails = null;
        String message = "Hello!";

        // Call the notifyUsersBatch() method under test and save the exception
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> notificationSystem.notifyUsersBatch(emails, message)
        );

        // Assert if the exception message is as expected
        String expectedMessage = "Email list cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void notifyUsersBatch_nullEmail_throwsException() {
        // Create some invalid parameters (including a null value). For this, we need to use ArrayList.
        List<String> emails = new ArrayList<>();
        emails.add("user1@example.com");
        emails.add(null);
        String message = "Hello!";

        // Call the notifyUsersBatch() method under test and save the exception
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> notificationSystem.notifyUsersBatch(emails, message)
        );

        // Assert if the exception message is as expected
        String expectedMessage = "Email address cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void notifyUsersBatch_emptyEmail_throwsException() {
        // Create some invalid parameters (including an empty address)
        List<String> emails = List.of("user1@example.com", "");
        String message = "Hello!";

        // Call the notifyUsersBatch() method under test and save the exception
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> notificationSystem.notifyUsersBatch(emails, message)
        );

        // Assert if the exception message is as expected
        String expectedMessage = "Email address cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }
}
