package org.example.problem.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class greedy4 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        StringTokenizer str;
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(str.nextToken());
            time[i][1] = Integer.parseInt(str.nextToken());
        }
        /*
         * time[][0] 은 시작시점을 의미
         * time[][1] 은 종료시점을 의미
         */

        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        /*
         * 끝나는 시점을 기준으로 배열을 정렬해준다
         * 끝나는 시간이 같을 경우에는 시작 시간이 빠른 순으로 정렬해준다.
         */

        int count = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            if(end <= time[i][0]) {
                end = time[i][1];
                count++;
            }
        }
        /*
         * 끝나는 시간순으로 정렬되어 있기 때문에 현재 저장되어 있는 end값이
         * for문을 돌면서 회의가 시작되는 시간보다 작으면 회의가 가능한 것이므로 count해주고
         * end값을 update해줌
         */
        return count;
    }
    /*
     * https://st-lab.tistory.com/145
     */
}
