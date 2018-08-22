package sort;

import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/3/29
 */
public class HeapSort1 {

    public static void main(String[] args) {
        int[] arr = {53, 23, 45, 86, 12, 33, 10, 90, 36, 70, 43, 88, 60, 29};
        System.out.println("排序之前： " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序之后： " + Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
    }

    private static void heapAdjust(int[] arr, int i, int length) {
      int child;
      for (int parent = arr[i]; leftChild(i) < length; i = child) {
          child = leftChild(i);
          if (child != length - 1 && arr[child] < arr[child + 1]) {
              child++;
          }

          if (arr[child] > parent) {
              swap(arr, i, child);
          } else {
              break;
          }
      }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



    private static int leftChild(int i) {
        return 2 * i+ 1;
    }
}
