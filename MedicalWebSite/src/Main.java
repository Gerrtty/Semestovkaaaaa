public class Main {
    public static void main(String[] args) {
        Password p1 = new Password("hello");
        Password p2 = new Password("hello2");
        System.out.println(p1.equals(p2));
    }
}
