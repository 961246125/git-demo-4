package org.example.test;

import lombok.Synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    private static Test1 test1;

    private static ReentrantLock lock = new ReentrantLock();

    private Test1(){
    }

    public static Test1 getInstance() {
        if (test1 == null) {
            lock.lock();
            if (test1 == null) {
                return test1 = new Test1();
            }
            lock.unlock();
        }
        return test1;
    }

    public static void main(String[] args) {
        Test1 test11 = Test1.getInstance();
    }
}
