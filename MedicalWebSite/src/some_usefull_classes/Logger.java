package some_usefull_classes;

public class Logger {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private static Logger logger = null;

    private Logger() { }

    public static Logger getLogger() {
        if(logger == null) {
            return new Logger();
        }
        else return logger;
    }

    public void red_wrie(String s) {
        System.out.println(ANSI_RED + s + ANSI_RESET);
    }

    public void green_write(String s) {
        System.out.println(ANSI_GREEN + s + ANSI_RESET);
    }
}
