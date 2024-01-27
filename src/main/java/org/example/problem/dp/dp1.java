package org.example.problem.dp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class dp1 {

    public static int solution(int N) throws Exception {
        int[] dp = new int[N + 1];

        if (N >= 3)
            dp[3] = 1;
        if (N >= 5)
            dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            if (i % 5 == 0) {
                dp[i] = dp[i - 5] + 1;
            } else if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;
            } else {
                if (dp[i - 3] != 0 && dp[i - 5] != 0) {
                    dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
                }
            }
        }

        if (dp[N] == 0) {
            return -1;
        }
        return dp[N];
    }

}
