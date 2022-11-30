package example.LeetCode;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high){
            return;
        }
        int p = arr[low];
        int i = low;
        int j = high;
        while( i < j) {
            while(i < j && arr[j] >= p) {
                j--;
            }
            while(i < j && arr[i] <= p) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[low] = arr[i];
        arr[i] = p;
        quickSort(arr, low, i-1);
        quickSort(arr, i+1, high);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,4,6,8,3,10,4,6,1,7,13,20};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
