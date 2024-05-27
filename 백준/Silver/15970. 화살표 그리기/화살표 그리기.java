import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        List<Integer> graph[] = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
 
            graph[y].add(x);
        }
 
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
 
        int result = 0;
        int max = 0;

        for (int i = 1; i <= N; i++) {
            max = graph[i].size() - 1;

            if (max < 1) continue;

            result += graph[i].get(1) - graph[i].get(0);

            for (int c = 1; c < max; c++) {
                result += Math.min(graph[i].get(c + 1) - graph[i].get(c), graph[i].get(c) - graph[i].get(c - 1));
            }

            result += graph[i].get(max) - graph[i].get(max - 1);
        }
 
        System.out.println(result);

        br.close();
    }
}