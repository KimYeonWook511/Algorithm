import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[1_000_002];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            arr[S]++;
            arr[E + 1]--;
        }

        for (int i = 1; i <= 1_000_000; i++) {
            arr[i] += arr[i - 1];
        }

        int Q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            sb.append(arr[Integer.parseInt(st.nextToken())]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}