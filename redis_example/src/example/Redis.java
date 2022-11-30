package example;

public class Redis {

    volatile static int  state = 0;

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> {
            while (true) {
                if (state == 0) {
                    System.out.println("1");
                    state = 1;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                if (state == 1) {
                    System.out.println("2");
                    state = 2;
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                if (state == 2) {
                    System.out.println("3");
                    state = 0;
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
    }
}
