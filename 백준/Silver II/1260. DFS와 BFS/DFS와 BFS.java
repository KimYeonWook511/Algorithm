import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, V, A, B;
    static boolean graph[][], chk[];
    static Deque<Integer> deque;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        deque = new ArrayDeque<>();

        for (int run = 0; run < M; run++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            graph[A][B] = true; // A -> B
            graph[B][A] = true; // B -> A
        }

        chk = new boolean[N + 1];
        dfs();

        sb.append("\n");

        chk = new boolean[N + 1];
        bfs();

        System.out.println(sb);

        br.close();
    }

    static void dfs() {
        deque.offerLast(V);

        while (!deque.isEmpty()) {
            B = deque.pollLast();

            if (chk[B]) continue;
            chk[B] = true;

            for (int A = N; A > 0; A--) {
                if (!graph[B][A]) continue;

                deque.offerLast(A);
            }

            sb.append(B).append(" ");
        }
    }

    static void bfs() {
        deque.offerLast(V);
        chk[V] = true;

        while (!deque.isEmpty()) {
            B = deque.pollFirst();

            for (int A = 1; A <= N; A++) {
                if (!graph[B][A] || chk[A]) continue;

                chk[A] = true;
                deque.offerLast(A);
            }

            sb.append(B).append(" ");
        }
    }
}