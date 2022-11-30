package example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutorThread {
    private ArrayBlockingQueue<Runnable> threadDeque;
    private List<WorkThread> workThreads;

    private Boolean isRun = Boolean.TRUE;

    private ExecutorThread(int maxThreadCount, int dequeSize) {
        threadDeque = new ArrayBlockingQueue<>(dequeSize);
        workThreads = new ArrayList<>(maxThreadCount);
        for (int i = 0; i < 2; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            workThreads.add(workThread);
        }
    }
    class WorkThread extends Thread{
        @Override
        public void run(){
            while (isRun || threadDeque.size() > 0) {
                Runnable runnable = threadDeque.poll();
                if(runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public void execute(Runnable runnable) {
        threadDeque.offer(runnable);
    }

    public static void main(String[] args) {
        ExecutorThread executorThread = new ExecutorThread(2,5);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorThread.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "," + finalI);
            });
        }
        executorThread.isRun = Boolean.FALSE;
    }
}
