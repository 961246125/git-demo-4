package example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;


public class ThreadTest01 {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();

    public static int threadlocal = 10;

    private final int threadLocalHashCode = nextHashCode();
    private static AtomicInteger nextHashCode = new AtomicInteger();
    private static final int HASH_INCREMENT = 0x61c88647;
    private static int nextHashCode() {
        int s = nextHashCode.getAndAdd(HASH_INCREMENT);
        return s;
    }
    public int getKey(){
        return threadLocalHashCode;
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("1 begin");
            threadLocal.set(1);
            System.out.println("1 end");
        }).start();
        System.out.println("456");
        new Thread(() -> {
            System.out.println("2 begin");
            threadLocal.set(2);
            System.out.println("2 end");
        }).start();
        System.out.println("789");

    }
}
