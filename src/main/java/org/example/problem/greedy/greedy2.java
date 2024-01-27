package org.example.problem.greedy;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class greedy2 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {

        BufferedReader br = toBufferedReader(input);

        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());

        int[] coin = new int[N];

        for(int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i = N - 1; i >= 0; i--) {

            if(coin[i] <= K) {
                count += (K / coin[i]);
                K = K % coin[i];
            }
        }
        return count;
    }

}
