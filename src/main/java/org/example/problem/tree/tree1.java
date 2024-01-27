package org.example.problem.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class tree1 {
    static int N;
    static int[] parent;
    static boolean[] isVisit;
    static StringTokenizer st;
    static ArrayList<Integer> list[];
    static StringBuilder sb = new StringBuilder();
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static String solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        sb.delete(0,sb.length());

        N = Integer.parseInt(br.readLine());
        isVisit = new boolean[N + 1];
        list = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) { //연결된 노드 값들을 입력받는다
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1); // 트리의 루트는 1

        for (int i = 2; i < parent.length; i++) { //결과값 출력
            sb.append(parent[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void dfs(int index) {
        isVisit[index] = true;
        for (int i : list[index]) {
            if (!isVisit[i]) {
                parent[i] = index; //parent list에 각 노드들의 부모값을 저장해준다
                dfs(i);
            }
        }
    }
}
