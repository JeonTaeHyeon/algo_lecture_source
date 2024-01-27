package org.example.problem.search;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS1 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    static Queue<Node> que = new LinkedList<>();
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};
    static int map[][];
    static boolean visit[][];
    static int cur_x, cur_y;
    static int N, M, K;
    static int count;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(String input) throws Exception {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        M = Integer.parseInt(str.nextToken());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int j = 0; j < K; j++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            map[y][x] = 1;
        }

        count = 0;
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {

                if (visit[j][k] == false && map[j][k] == 1) {
                    count++;
                    BFS(k, j);
                }
            }
        }

        return count;

    }

    static void BFS(int x, int y) {
        que.offer(new Node(x, y));
        visit[y][x] = true;

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                cur_x = node.x + dirX[i];
                cur_y = node.y + dirY[i];

                if (Range_check() && visit[cur_y][cur_x] == false && map[cur_y][cur_x] == 1) {
                    que.offer(new Node(cur_x, cur_y));
                    visit[cur_y][cur_x] = true;
                }

            }
        }
    }

    public static boolean Range_check() {
        return (cur_x >= 0 && cur_x < M && cur_y >= 0 && cur_y < N);
    }

}
