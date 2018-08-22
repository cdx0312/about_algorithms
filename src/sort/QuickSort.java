package sort;

import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/3/28
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {53, 23, 45, 86, 12, 33, 10, 90, 36, 70, 43, 88, 60, 29};
        System.out.println("排序之前： " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序之后： " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSortHelp(arr, 0, arr.length - 1);
    }

    private static void quickSortHelp(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSortHelp(arr, low, pivot - 1);
            quickSortHelp(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot)
                high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
