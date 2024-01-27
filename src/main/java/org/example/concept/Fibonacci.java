package org.example.concept;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 10;  // 원하는 피보나치 수열의 항 개수
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    static int[] DP;
    public static int fibonacciMemo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if (DP[n] == 0) {
                DP[n] = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
            }
            return DP[n];
        }
    }

    public static int fibonacciIterative(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int fibPrev = 0;
            int fibCurr = 1;
            for (int i = 2; i <= n; i++) {
                int temp = fibCurr;
                fibCurr = fibPrev + fibCurr;
                fibPrev = temp;
            }
            return fibCurr;
        }
    }

    public int fibonacciIter(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        if(n == 0) return arr[0];
        else if(n == 1) return arr[1];
        else {
            for (int i = 2; i < n+1; i++) arr[i] = arr[i-1] % 1234567 + arr[i-2] % 1234567;
            return arr[n] % 1234567;
        }
    }
}
