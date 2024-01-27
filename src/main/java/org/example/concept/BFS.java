package org.example.concept;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
        boolean[] visited = new boolean[9];
        bfs(1, graph, visited);
    }

    static void bfs(int start, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int nodeIndex = q.poll();
            System.out.print(nodeIndex + " -> ");
            for (int i = 0; i < graph[nodeIndex].length; i++) {
                int temp = graph[nodeIndex][i];
                if (!visited[temp]) {
                    visited[temp] = true;
                    q.offer(temp);
                }
            }
        }
    }
}
