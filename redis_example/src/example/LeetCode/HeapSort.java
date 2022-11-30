package example.LeetCode;

import java.util.Arrays;

public class HeapSort {

    public static void adjustHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int left = 2 * parent + 1;
        while (left < length) {
            int right = left + 1;
            int k = left;
            if (right < length && arr[right] > arr[left]) {
                k = right;
            }
            if (arr[k] <= temp) {
                break;
            }
            arr[parent] = arr[k];
            arr[k] = temp;
            parent = k;
            left = 2 * parent + 1;
        }
    }
    public static void heapSort(int[] arr) {
        for (int i = (arr.length-1)/2; i >= 0; i--) {
            adjustHeap(arr,i, arr.length);
        }
        for (int i = arr.length-1; i >= 0; i--) {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            adjustHeap(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,4,6,8,3,10,4,6,1,7,13,20};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
