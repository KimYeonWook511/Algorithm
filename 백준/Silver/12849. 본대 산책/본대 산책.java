import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int D = Integer.parseInt(br.readLine());

        // 0: 정보과학관 / 1: 전산관 / 2: 미래관 / 3: 신양관
        // 4: 한경직기념관 / 5: 진리관 / 6: 학생회관 / 7: 형남공학관
        List<Integer> graph[] = new List[8];
        for (int i = 0; i < 8; i++) {
            graph[i] = new ArrayList<>();
        }
        initGraph(graph);

        int dp[][] = new int[2][8];
        dp[1][1] = 1;
        dp[1][2] = 1;
        int pre = 1;
        int cur = 0;
        for (int i = 2; i <= D; i++) {
            for (int j = 0; j < 8; j++) {
                dp[cur][j] = 0;
                for (int preNode : graph[j]) {
                    dp[cur][j] = (dp[cur][j] + dp[pre][preNode]) % MOD;
                }
            }
            pre = cur;
            cur = 1 - cur;
        }

        System.out.println(dp[pre][0]);

        br.close();
    }

    static void initGraph(List<Integer> graph[]) {
        // 정보과학관
        graph[0].add(1);
        graph[0].add(2);

        // 전산관
        graph[1].add(0);
        graph[1].add(2);
        graph[1].add(3);

        // 미래관
        graph[2].add(0);
        graph[2].add(1);
        graph[2].add(3);
        graph[2].add(4);

        // 신양관
        graph[3].add(1);
        graph[3].add(2);
        graph[3].add(4);
        graph[3].add(5);

        // 한경직기념관
        graph[4].add(2);
        graph[4].add(3);
        graph[4].add(5);
        graph[4].add(7);

        // 진리관
        graph[5].add(3);
        graph[5].add(4);
        graph[5].add(6);

        // 학생회관
        graph[6].add(5);
        graph[6].add(7);

        // 형남공학관
        graph[7].add(4);
        graph[7].add(6);
    }
}