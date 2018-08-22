package leetcode.dp;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class Fib {
    //O(2^N)
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n-1) + fib(n-2);
    }

    //O(N)
    public int fib2(int n) {
        int[] res = new int[n + 1];
         res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < n+1; i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        long startTime = System.currentTimeMillis();
        int n = 42;
        System.out.println("fib(" + n + ") = " + fib.fib(n));
        System.out.println("time : " + (System.currentTimeMillis() - startTime));

        long startTime1 = System.currentTimeMillis();
        System.out.println("fib(" + n + ") = " + fib.fib2(n));
        System.out.println("time : " + (System.currentTimeMillis() - startTime1));

    }
}
