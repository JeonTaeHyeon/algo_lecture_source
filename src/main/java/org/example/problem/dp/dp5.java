package org.example.problem.dp;

import java.io.*;

public class dp5 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        int N = Integer.parseInt(br.readLine());

        int[] DP = new int[N + 1];
        int[] arr = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        DP[1] = arr[1];

        if (N >= 2) {
            DP[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= N; i++) {
            DP[i] = Math.max(DP[i - 2] , DP[i - 3] + arr[i - 1]) + arr[i];
        }
        /*
         * 2개의 계단을 점프해서 현재 위치의 계단에 도착하거나
         * 1계의 계단을 점프해서 현재 위치의 계딴에 도착할 수 있다
         * 1개의 계단을 점프한 경우에는 이전에도 1개의 계단을 점프했다면 3개의 계단을 연속으로 밟기 때문에
         * DP[i - 3] + arr[i - 1] 처럼 이전에는 2개의 계단을 점프하도록 해야한다.
         */

        return DP[N];
    }
}
