import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> graph[];
    static int chk[], i;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        chk = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        func(R);

        for (int i = 1; i <= N; i++) {
            sb.append(chk[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void func(int cur) {
        chk[cur] = ++i;
        
        Collections.sort(graph[cur], new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        for (int next : graph[cur]) {
            if (chk[next] != 0) continue;

            func(next);
        }
    }
}