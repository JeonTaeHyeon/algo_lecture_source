package org.example.concept;

import java.util.Stack;

public class DFS {
    static boolean[] vistied = new boolean[9];
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        stack.push(1);
        vistied[1] = true;

        while (!stack.isEmpty()) {
            int nodeIndex = stack.pop();
            System.out.print(nodeIndex + " -> ");
            for (int LinkedNode : graph[nodeIndex]) {
                if (!vistied[LinkedNode]) {
                    stack.push(LinkedNode);
                    vistied[LinkedNode] = true;
                }
            }
        }
    }
}
