package some_usefull_classes;

import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        final String p = "^[0-9]*";

         Pattern pattern = Pattern.compile(p);

        System.out.println(isCorrect("123", pattern));
        System.out.println(isCorrect("nfjnjng", pattern));
        System.out.println(isCorrect("12a3", pattern));

    }

    public static boolean isCorrect(String s, Pattern pattern) {
        return pattern.matcher(s).matches();
    }

}
