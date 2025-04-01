import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        int result[] = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            result[i] = Integer.MAX_VALUE;
        }

        int dist[] = new int[N];
        for (int xi = 0; xi < N; xi++) {
            for (int yi = 0; yi < N; yi++) {
                for (int i = 0; i < N; i++) {
                    int x = arr[xi][0] - arr[i][0];
                    int y = arr[yi][1] - arr[i][1];

                    dist[i] = Math.abs(x) + Math.abs(y);
                }

                Arrays.sort(dist);
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    sum += dist[i];
                    result[i] = Math.min(result[i], sum);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}