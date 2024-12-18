import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        long l = 0;
        long r = 0;
        long sum = 0;
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) % 2 != 0) continue;
			
            l += i;
            r += N - 1 - i;
            sum += cnt++;
        }

        System.out.println(Math.min(l, r) - sum);

        br.close();
    }
}