package org.example.problem.search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSDFS1 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> q = new LinkedList<>();

    public static String solution(String input) throws IOException {
        sb.delete(0,sb.length());
        BufferedReader br = toBufferedReader(input);

        StringTokenizer str1 = new StringTokenizer(br.readLine());
        node = Integer.parseInt(str1.nextToken());
        line = Integer.parseInt(str1.nextToken());
        start= Integer.parseInt(str1.nextToken());
        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i = 0 ; i < line ; i ++) {
            StringTokenizer str2 = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str2.nextToken());
            int b = Integer.parseInt(str2.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }
        dfs(start);
        sb.append("\n");
        check = new boolean[node+1];

        bfs(start);
        return sb.toString();
    }
    public static void dfs(int start) {

        check[start] = true;
        sb.append(start + " ");

        for(int i = 0 ; i <= node ; i++) {
            if(arr[start][i] == 1 && !check[i])
                dfs(i);
        }

    }

    public static void bfs(int start) {
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            sb.append(start + " ");

            for(int i = 1 ; i <= node ; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }


    }
}
