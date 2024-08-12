import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        
        if (N != 0) {
            cnt = 1;
            int temp = 0;
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int cur = Integer.parseInt(st.nextToken());
    
                if (temp + cur <= M) {
                    temp += cur;
                    continue;
                }
    
                cnt++;
                temp = cur;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}