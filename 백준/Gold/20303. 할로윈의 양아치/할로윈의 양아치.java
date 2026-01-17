import java.io.*;
import java.util.*;

public class Main {
    static int parents[];
    static int ranks[];
    static int candies[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        ranks = new int[N + 1];
        candies = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int count = Integer.parseInt(st.nextToken());
            parents[i] = -1;
            candies[i] = count;
        }

        int groupCount = N;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (union(a, b)) {
                groupCount--;
            }
        }

        // 부모 인덱스 저장
        int parentIndex[] = new int[groupCount];
        for (int i = 1; i <= N; i++) {
            if (parents[i] < 0) {
                groupCount--;
                parentIndex[groupCount] = i;
            }
        }

        int dp[] = new int[K];
		for (int idx : parentIndex) {
            int minCol = (parents[idx] * -1); // parents[idx]는 친구 수(음수)
			for (int c = K - 1; c >= minCol; c--) {
				dp[c] = Math.max(dp[c], dp[c + parents[idx]] + candies[idx]);
			}
		}

        System.out.println(dp[K - 1]);

        br.close();
    }

    static int find(int x) {
        if (parents[x] < 0) return x;

        return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        if (ranks[x] < ranks[y]) {
            parents[y] += parents[x];
            candies[y] += candies[x];
            parents[x] = y;
        } else if (ranks[x] > ranks[y]) {
            parents[x] += parents[y];
            candies[x] += candies[y];
            parents[y] = x;
        } else {
            parents[x] += parents[y];
            candies[x] += candies[y];
            parents[y] = x;
            ranks[x]++;
        }
        return true;
    }
}