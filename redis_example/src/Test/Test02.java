package Test;

public class Test02 {

    public int findK(int[] a, int[] b, int K) {
        int aLen = a.length;
        int bLen = b.length;
        int n = aLen + bLen;
        int[] result = new int[n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < aLen && j < bLen && k < n) {
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
                k++;
            } else {
                result[k] = b[j];
                j++;
                k++;
            }
        }
        if (i < aLen) {
            while (i < aLen) {
                result[k] = a[i];
                i++;
                k++;
            }
        } else if (j < bLen) {
            while (j < bLen) {
                result[k] = b[j];
                j++;
                k++;
            }
        }
        if (K >= n) {
            return -1;
        }else {
            return result[K-1];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 9};
        int[] b = new int[]{2, 4, 6, 10};
        Test02 test02 = new Test02();
        System.out.println(test02.findK(a,b,7));
    }
}
