import javax.mail.MessagingException;

public class Main {
    public static void main(String[] args) {
        String username = "yourmail@example.com";
        String password = "yourpassword";

        EmailService emailService = new EmailService(username, password);

        try {
            emailService.sendEmail("yourmail@example.com", "Hatırlatma", "Etkinlik vaktiniz geldi, lütfen ajandayı kontrol edin.");
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}

