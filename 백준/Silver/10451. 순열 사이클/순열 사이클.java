import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T ; t++){
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N + 1];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            boolean visited[] = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                int next = arr[i];

                while(true) {
                    if(visited[next]) {
                        cnt++;
                        break;
                    }

                    visited[next] = true;
                    next = arr[next];
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}