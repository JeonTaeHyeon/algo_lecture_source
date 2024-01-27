package org.example.problem.dp;

import java.io.*;

public class dp3 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer[] dp = new Integer[101];

    public static int solution(int n) throws IOException {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        return pado(n);
    }
    public static int pado(int N) {
        if(dp[N] == null) {
            dp[N] = pado(N - 2) + pado(N - 3);
        }
        return dp[N];
    }
}
