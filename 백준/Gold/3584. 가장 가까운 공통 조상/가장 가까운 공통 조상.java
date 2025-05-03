import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int parent[] = new int[N + 1];

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                parent[B] = A;
            }

            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean visited[] = new boolean[N + 1];

            // A 부모 체크
            visited[A] = true;
            while (true) {
                int next = parent[A];

                if (next == 0) break;

                visited[next] = true;
                A = next;
            }

            // B 부모 체크
            while (true) {
                if (visited[B]) {
                    sb.append(B).append("\n");
                    break;
                }

                B = parent[B];
            }
        }

        System.out.println(sb);
        
        br.close();
    }
}