import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N, M;
    static List<Integer> graph[];
    static boolean chk[], flag;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        chk = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int run = 0; run < M; run++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            func(0, i);

            if (flag) break;
        }

        System.out.println(flag ? "1" : "0");

        br.close();
    }

    static void func(int cnt, int i) {
        if (flag) return; // 빠른 탈출

        if (cnt == 4) {
            flag = true;

            return;
        }

        chk[i] = true;

        for (int next : graph[i]) {
            if (!chk[next]) func(cnt + 1, next);
        }

        chk[i] = false;
    }
}