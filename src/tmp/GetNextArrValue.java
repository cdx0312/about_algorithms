package tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/3/31
 */
public class GetNextArrValue {
    public static void main(String[] args) {
        int[] arr = {1, 34, 35, 29, 17, 12, 3, 6, 4, 9 ,25, 5};
        int[] result = help(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result));
    }

    /**
     * O(N)复杂度
     * @param arr
     * @return
     */
    private static int[] help(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i] > arr[i-1]) {
                stack.push(arr[i]);
            }
        }
        int index = stack.pop();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < index)
                result[i] = index;
            else {
                if (stack != null) {
                    index = stack.pop();
                    result[i] = index;
                } else {
                    result[i] = -1;
                }

            }
        }
        return result;
    }

    /**
     * O（n^2）复杂度的方法
     * @param arr
     * @return
     */
//    private static int[] help(int[] arr) {
//        int[] result = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[j] > arr[i]) {
//                    result[i] = arr[j];
//                    break;
//                }
//                result[i] = -1;
//            }
//        }
//        result[arr-1] = -1;
//        return result;
//    }


}
