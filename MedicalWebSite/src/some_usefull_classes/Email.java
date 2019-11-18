package some_usefull_classes;
import java.util.regex.Pattern;

public class Email {
    private String email;

    private static final String EMAIL_PATTERN = "^[_0-9a-z-\\.]+\\@[0-9a-z-]{2,}\\.[a-z]{2,}$";

    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public Email(String email) {
        this.email = email;
    }

    public boolean isCorrect() {
        return pattern.matcher(email).matches();
    }

    public static boolean isCorrect(String email) {
        return pattern.matcher(email).matches();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
