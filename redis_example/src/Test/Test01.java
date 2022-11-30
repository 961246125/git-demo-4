package Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Test01 {

    public int[] isLoop(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int[] result = new int[aLen + bLen];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < aLen && j < bLen && k < aLen + bLen) {
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            } else  {
                result[k] = b[j];
                j++;
            }
            k++;
        }
        if (i < aLen) {
            while (k < aLen + bLen) {
                result[k] = a[i];
                i++;
                k++;
            }
        }else if (j < bLen){
            while (k < aLen + bLen) {
                result[k] = b[j];
                j++;
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a =new int[] {1,3,5,7};
        int[] b = new int[] {2,4,6,8,10};
        Test01 test01 = new Test01();
        int[] result = test01.isLoop(a,b);

    }
}
