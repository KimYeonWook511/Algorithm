import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int parent[];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        int edge[][] = new int[M + 1][2];

        for (int w = 1; w <= M; w++) {
            // 이미 정렬 됨
            st = new StringTokenizer(br.readLine());

            edge[w][0] = Integer.parseInt(st.nextToken());
            edge[w][1] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        int tempW = 0;

        for (int turn = 0; turn < K; turn++) {
            if (!flag) {
                sb.append("0 ");
                continue;
            }

            int cnt = N - 1;
            int sum = 0;
            
            // 초기화
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            // 간선 제거
            edge[tempW][0] = 0;

            for (int w = 1; w <= M; w++) {
                if (edge[w][0] == 0) continue; // 제거된 간선
                if (!union(edge[w][0], edge[w][1])) continue;

                if (sum == 0) tempW = w; // 다음 턴에 제거할 간선

                sum += w;
    
                if (--cnt == 0) break;
            }
    
            if (cnt != 0) flag = false;

            sb.append(flag ? sum : "0").append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        if (x < y) parent[y] = x;
        else parent[x] = y;

        return true;
    }
}