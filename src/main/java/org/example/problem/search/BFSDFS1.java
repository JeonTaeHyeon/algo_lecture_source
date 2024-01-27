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
    static boolean[] visit;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> q = new LinkedList<>();

    public static String solution(String input) throws IOException {
        sb.delete(0,sb.length());
        /*
         * 여러개 테스트 진행하면 StringBuilder에 값이 남아있어서 제거
         */
        BufferedReader br = toBufferedReader(input);

        StringTokenizer str1 = new StringTokenizer(br.readLine());
        node = Integer.parseInt(str1.nextToken());
        line = Integer.parseInt(str1.nextToken());
        start= Integer.parseInt(str1.nextToken());
        arr = new int[node+1][node+1];
        visit = new boolean[node+1];

        for(int i = 0 ; i < line ; i ++) {
            StringTokenizer str2 = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str2.nextToken());
            int b = Integer.parseInt(str2.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }
        /*
         * 인접리스트 방식으로 그래프 연결 표현
         */
        dfs(start);
        sb.append("\n");
        visit = new boolean[node+1];

        bfs(start);
        return sb.toString();
        /*
         * 결과값 비교를 String 타입으로 진행해야 되다보니 전반적으로 StringBuilder에 값을 이어붙이는 방식으로 진행
         */
    }
    public static void dfs(int start) {

        visit[start] = true;
        sb.append(start + " ");

        for(int i = 0 ; i <= node ; i++) {
            if(arr[start][i] == 1 && !visit[i])
                dfs(i);
        }

    }

    public static void bfs(int start) {
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            sb.append(start + " ");

            for(int i = 1 ; i <= node ; i++) {
                if(arr[start][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }


    }
}
