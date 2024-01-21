import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[], result[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        func(0, 0);

        System.out.println(sb.toString());

        br.close();
    }

    static void func(int cnt, int startIdx) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return;
        }
        
        int pre = 0;

        for (int i = startIdx; i < N; i++) {
            if (arr[i] == pre) continue; 
            
            result[cnt] = arr[i];
            func(cnt + 1, i);
            pre = arr[i];
        }
    }
}