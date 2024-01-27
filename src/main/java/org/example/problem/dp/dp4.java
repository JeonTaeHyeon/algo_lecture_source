package org.example.problem.dp;

import java.io.*;
import java.util.StringTokenizer;

public class dp4 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        int n = Integer.parseInt(br.readLine());

        int DP[][] = new int[n+1][n+1];
        int a[][] = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + a[i][j];
            }
        }
        /*
            5
            7
            3 8
            8 1 0
            2 7 4 4
            4 5 2 6 5
            위와 같이 입력이 주어졌을 때 dp[i-1][j] (바로위), dp[i-1]dp[j-1] (왼쪽 위)중 큰 값을 현재 위치의 값과 더하는 방식으로
            점화식 설정
         */
        int ans=0;
        for(int i=1; i<=n; i++) {
            if(ans < DP[n][i]) ans = DP[n][i];
        }

        return ans;
    }
}
