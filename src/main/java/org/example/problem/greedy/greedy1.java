package org.example.problem.greedy;

public class greedy1 {
    public static int solution(int n) {
        int cnt=0;
        while(true) {
            if(n % 5 == 0) {
                return (n/5 + cnt);
            }
            else if(n < 0) {
                return -1;
            }
            n = n-3;
            cnt++;
        }
    }
}
