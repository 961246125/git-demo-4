package example.LeetCode;

public class Singlenton {

    private static Singlenton singlenton;

    private final String s = "123";
    private Singlenton() {}

    synchronized public  final void gethand() {
        System.out.println("123");
    }
    public synchronized static Singlenton getInstanse() {
        if (singlenton == null) {
            singlenton = new Singlenton();
            return singlenton;
        }
        return singlenton;
    }

    public static void main(String[] args) {
        Singlenton singlenton1 = Singlenton.getInstanse();
    }
}
