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

    static Queue<Node> q = new LinkedList<>();
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};
    /*
     * 상하좌우로 이동하면 체크하기 위한 배열 선언
     */
    static int map[][];
    static boolean visit[][];
    /*
     * 방문배열과 그래프 정보를 저장할 배열 선언
     */
    static int cur_x, cur_y;
    /*
     * 그래프 탐색을 진행하면서 현재 위치에 대한 정보를 저장할 변수
     */
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
    /*
     * 2차원 좌표 처럼 접근하기 위한 Node 클래스
     */

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
        /*
         * buffer에 닮겨 있는 정보를 각각 변수에 저장
         */

        count = 0;
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {

                if (visit[j][k] == false && map[j][k] == 1) {
                    count++;
                    BFS(k, j);
                }
            }
        }
        /*
         * visit[j][k] == false && map[j][k] == 1 이면 아직 방문하지 않은 새로운 Node이므로 BFS 진행
         */

        return count;

    }

    static void BFS(int x, int y) {
        q.offer(new Node(x, y));
        visit[y][x] = true;
        /*
         * 받아온 2차원 좌표를 queue에 삽입하고 방문배열 체크
         */
        while (!q.isEmpty()) {
            Node node = q.poll();
            /*
             * queue의 가장 앞에 있는 값을 빼면서 저장
             */

            for (int i = 0; i < 4; i++) {
                cur_x = node.x + dirX[i];
                cur_y = node.y + dirY[i];
                /*
                 * 상하좌우를 확인하면서 연결되어있으면 q에 push하고 방문배열 체크
                 */
                if (Range_check() && visit[cur_y][cur_x] == false && map[cur_y][cur_x] == 1) {
                    q.offer(new Node(cur_x, cur_y));
                    visit[cur_y][cur_x] = true;
                }

            }
        }
    }

    public static boolean Range_check() {
        return (cur_x >= 0 && cur_x < M && cur_y >= 0 && cur_y < N);
        /*
         * 그래프 범위 체크
         */
    }

}
