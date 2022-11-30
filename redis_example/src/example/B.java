package example;

import java.util.concurrent.ThreadPoolExecutor;

public class B {

    public void mB(String value) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(value);
                try {
                    Thread.sleep(150);
                } catch (Exception e) {

                }
            }
        }
    }

    synchronized public void mC(String value) {
        for (int i = 0; i < 10; i++) {
            System.out.println(value);
            try{
                Thread.sleep(150);
            }catch(Exception e){

            }
        }
    }

    public static void main(String[] agrs){
        System.out.println("Main 线程 开始运行!");
        final B b1 = new B();
        final B b2 = new B();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                System.out.println("t1 开始运行!");
                b1.mB("HAHA");
                System.out.println("t1 结束运行!");
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run(){
                System.out.println("t2 开始运行!");
                b2.mB("XIXI");
                System.out.println("t2 结束运行!");
            }
        };
        t2.start();

        System.out.println("Main 线程 结束运行!");
    }

}

