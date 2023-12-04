import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;

        if (K <= M) {
            for (int r = 0; r < N; r++) {
                String line = br.readLine();
    
                int cnt = 0;
    
                for (int i = 0; i < K; i++) {
                    if (line.charAt(i) == '1') cnt++;
                }
    
                if (cnt == 0) result++;
    
                for (int i = K; i < M; i++) {
                    if (line.charAt(i) == '1') cnt++;
    
                    if (line.charAt(i - K) == '1') cnt--;
    
                    if (cnt == 0) result++;
                }
            }

        } else {
            for (int r = 0; r < N; r++) {
                br.readLine();
            }
        }

        System.out.println(result);

        br.close();
    }
}