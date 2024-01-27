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
        /*
         * 5kg로 안나눠지면 3kg짜리로 일단 빼고 5kg으로 나눠지면 무조건 5kg으로 나머지 처리
         * n이 0보다 작아지면 5kg로 안나눠져서 3kg로 처리하다가 음수가 된 경우이므로 -1
         */
    }
}
