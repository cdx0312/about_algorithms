package sort;

import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/3/28
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {53, 23, 45, 86, 12, 33, 10, 90, 36, 70, 43, 88, 60, 29};
        System.out.println("排序之前： " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序之后： " + Arrays.toString(arr));
    }

    /**
     * 堆排序方法
     * @param arr 待排序的数组
     */
    private static void heapSort(int[] arr) {
        //1、创建大根堆，从第一个非叶子节点向堆首元素进行交换
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        //最后一个节点与root节点交换，然后调整成大根堆，
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
    }

    /**
     * 构建堆的过程
     * @param arr 需要排列的数组
     * @param i 需要构建堆的根节点的序号
     * @param length 堆元素的个数，随着出堆不断的减少
     */
    private static void heapAdjust(int[] arr, int i, int length) {
        int child;
        for (int fathre = arr[i]; leftChild(i) < length; i = child) {
            child = leftChild(i);
            //选择节点i的较大的孩子节点
            if (child != length - 1 && arr[child] < arr[child+1]) {
                child++;
            }
            //如果父节点的值小于其较大的孩子节点，则交换二者的值
            if (fathre < arr[child]) {
                swap(arr, i, child);
            } else {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp =arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int leftChild(int i) {
        return 2 * i+ 1;
    }

}
