package leetcode.dp;

import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/4/12
 */
public class WiggleSubswquence_376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1)
            return n;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1]) {
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            } else {
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        System.out.println(Arrays.toString(up));
        System.out.println(Arrays.toString(down));
        return Math.max(down[n-1], up[n-1]);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(new WiggleSubswquence_376().wiggleMaxLength(arr));
    }
}
