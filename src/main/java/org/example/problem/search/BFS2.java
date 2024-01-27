package org.example.problem.search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS2 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    static boolean[][] visit;
    static int[][] map;
    static int[] dirX = {0, 0, 1, -1};
    static int[] dirY = {1, -1, 0, 0};
    static int N, M;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(String input) throws IOException {

        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();

            for(int j = 0 ; j < ch.length ; j++) {
                map[i][j] = Character.getNumericValue(ch[j]);
            }
            /*
             * 입력에 개행문자 없이 붙어서 들어왔으므로 위와 같이 처리
             */
        }
        visit[0][0] = true;
        bfs(0,0);

        return map[N-1][M-1];
    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));

        while(!q.isEmpty()) {
            Node s = q.poll();
            for (int i = 0; i < 4; i++) {
                int curX = s.x + dirX[i];
                int curY = s.y + dirY[i];

                if (curX < 0 || curY < 0 || curX >= N || curY >= M) {
                    continue;
                }
                if (visit[curX][curY] || map[curX][curY] == 0) {
                    continue;
                }
                q.add(new Node(curX, curY));
                map[curX][curY] = map[s.x][s.y] + 1;
                visit[curX][curY] = true;
            }
        }
    }


}
