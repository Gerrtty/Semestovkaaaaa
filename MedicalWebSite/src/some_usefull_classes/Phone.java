package some_usefull_classes;

import java.util.regex.Pattern;

public class Phone implements isCorrect{
    private String phone;

    private static final String EMAIL_PATTERN = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$";

    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public Phone(String phone) {
        this.phone = phone;
    }

    public boolean isCorrect() {
        return pattern.matcher(phone).matches();
    }

    public static boolean isCorrect(String phone) {
        return pattern.matcher(phone).matches();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String email) {
        this.phone = email;
    }
}
