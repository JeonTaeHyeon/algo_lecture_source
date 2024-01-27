package org.example.problem.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DFS1 {
    static boolean[] visit; //방문 체크를 위한 배열
    static int[][] map; //그래프 정보를 저장할 배열
    static int count = 0; //몇개까지 감염되었는지 저장
    static int node, edge; //node와 edge 개수
    static Queue<Integer> q = new LinkedList<>();

    public static BufferedReader toBufferedReader(String str){
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }
    /*
     * 개행문자 처리를 위해 input을 BufferedReader로 변환해줌
     */

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        map = new int[node+1][node+1];
        /*
         * // 인접리스트 형태로 정점과 간선의 정보를 저장
         */
        visit = new boolean[node+1];
        /*
         * 방문배열
         */

        for(int i = 0 ; i < edge ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            map[a][b] = map[b][a] =  1;
        }
        /*
         * 인접리스트로 그래프 표현
         */

        dfs(1);

        return count-1;
        /*
         * 시작점도 count되었으므로 1을 뺴줘야됨
         */
    }
    public static void dfs(int start) {
        visit[start] = true;
        count++;

        for(int i = 0 ; i <= node ; i++) {
            if(map[start][i] == 1 && !visit[i])
                dfs(i);
            /*
             * 아직 방문하지 않았는데 연결되어 있으면 dfs 진행
             */
        }
    }
}
