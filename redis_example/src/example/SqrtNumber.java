package example;

import lombok.Synchronized;

import java.util.*;

public class SqrtNumber {

    public static String sqrtNumer(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while( i * i <= n) {
            i++;
        }
        int one = i-1;
        double number = one;
        stringBuilder.append(one).append(".");

        for (int j = 1; j <= k; j++) {
            double temp = (float) 1 / Math.pow(10, j);
            for (int m = 1; m <= 10; m++) {
                if ((number + temp * m) * (number + temp * m) > n) {
                    number = number + temp * (m-1);
                    stringBuilder.append(m-1);
                    break;
                };
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SqrtNumber sqrtNumber = new SqrtNumber();
        System.out.println(sqrtNumber.sqrtNumer(4, 5));
        int[] a = new int[]{1,2,3};
    }
}
