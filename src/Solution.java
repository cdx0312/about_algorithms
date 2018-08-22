public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        if (A.length == 1)
            return 1;
        int index = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i-1]) {
                A[index++] = A[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4};
        System.out.println(new Solution().removeDuplicates(arr));
    }
}