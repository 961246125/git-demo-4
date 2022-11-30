package org.example.test1;

public class Test7 {

    private static Test7 test7 = new Test7();
    private static int value0;
    private static int value1 = 3;

    private Test7() {
        value0++;
        value1++;
    }

    public static void main(String[] args) {
        System.out.println(Test7.value0);
        System.out.println(Test7.value1);
    }
}
