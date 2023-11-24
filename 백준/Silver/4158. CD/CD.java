import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
    
            if (N == 0 && M == 0) break;

            Set<Integer> set = new HashSet<>();
            int cnt = 0;
    
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }
    
            for (int i = 0; i < M; i++) {
                if (set.contains(Integer.parseInt(br.readLine()))) cnt++;
            }
    
            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}