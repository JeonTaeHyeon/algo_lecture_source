package org.example.problem.dp;

import java.io.*;

public class dp3 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer[] seq = new Integer[101];

    public static int solution(int n) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        seq[0] = 0;
        seq[1] = 1;
        seq[2] = 1;
        seq[3] = 1;
        return pado(n);
    }
    public static int pado(int N) {
        if(seq[N] == null) {
            seq[N] = pado(N - 2) + pado(N - 3);
        }
        return seq[N];
    }
}
