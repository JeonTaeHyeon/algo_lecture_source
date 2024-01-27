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
    /*개행문자 처리를 위해 input을 BufferedReader로 변환해줌
    * 일반적으로 자바로 코딩테스트를 진행할 때 BufferReader를 많이 사용함
    */

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        node = Integer.parseInt(br.readLine()); // 정점의 개수
        edge = Integer.parseInt(br.readLine()); // 간선의 개수
        map = new int[node+1][node+1]; // 인접리스트 형태로 정점과 간선의 정보를 저장
        visit = new boolean[node+1]; //방문 배열

        for(int i = 0 ; i < edge ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            map[a][b] = map[b][a] =  1; //1이면 연결
        }//노드 간선 정보 입력

        dfs(1);

        return count-1;
    }
    public static void dfs(int start) {
        visit[start] = true;
        count++; //시작점과 연결되어있어 있는 것이므로 count

        for(int i = 0 ; i <= node ; i++) {
            if(map[start][i] == 1 && !visit[i]) //아직 방문하지 않았는데 연결되어 있으면
                dfs(i); // 탐색
        }
    }
}
