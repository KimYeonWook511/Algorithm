import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int score[][] = new int[n + 1][k + 1];
            int submit[] = new int[n + 1];
            int last[] = new int[n + 1];
            for (int time = 1; time <= m; time++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                score[id][num] = Math.max(score[id][num], s);
                submit[id]++;
                last[id] = time;
            }

            int total[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    total[i] += score[i][j];
                }
            }

            int answer = 1; // 순위
            for (int i = 1; i <= n; i++) {
                if (i == t) continue;

                if (total[i] > total[t]) answer++;
                else if (total[i] == total[t]) {
                    if (submit[i] < submit[t]) answer++;
                    else if (submit[i] == submit[t] && last[i] < last[t]) answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
