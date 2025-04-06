import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int graph[][] = new int[V + 1][V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }

        for (int m = 1; m <= V; m++) {
            for (int s = 1; s <= V; s++) {
                if (graph[s][m] == 0) continue;

                for (int e = 1; e <= V; e++) {
                    if (graph[m][e] == 0) continue;

                    if (graph[s][e] == 0) graph[s][e] = graph[s][m] + graph[m][e];
                    else graph[s][e] = Math.min(graph[s][e], graph[s][m] + graph[m][e]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            if (graph[i][i] == 0) continue;

            result = Math.min(result, graph[i][i]);
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

        br.close();
    }
}