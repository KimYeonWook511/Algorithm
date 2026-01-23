import java.io.*;
import java.util.*;

public class Main {
    static class Meeting {
        int start, end, people;

        Meeting (int start, int end, int people) {
            this.start = start;
            this.end = end;
            this.people = people;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Meeting meetings[] = new Meeting[N + 1];
        meetings[0] = new Meeting(-1, 0, 0);
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end, people);
        }

        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        int dp[] = new int[N + 1];
        dp[1] = meetings[1].people;
        for (int i = 2; i <= N; i++) {
            // i번째 회의를 선택하지 않는 경우
            dp[i] = dp[i - 1];

            // i번째 회의를 선택하는 경우
            if (meetings[i - 1].end > meetings[i].start) {
                // 바로 이전 회의와 겹침
                dp[i] = Math.max(dp[i], meetings[i].people + dp[i - 2]);
            } else {
                // 겹치지 않음
                dp[i] = Math.max(dp[i], meetings[i].people + dp[i - 1]);
            }
        }

        System.out.println(dp[N]);

        br.close();
    }
}
