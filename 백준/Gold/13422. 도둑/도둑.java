import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();

    	int T = Integer.parseInt(br.readLine());
    	
    	int N, M, K, sum[], cnt;
    	for (int run = 0; run < T; run++) {
    		st = new StringTokenizer(br.readLine());
    		
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		K = Integer.parseInt(st.nextToken());
    		
    		sum = new int[N + 1];
    		cnt = 0;
    		
    		st = new StringTokenizer(br.readLine());
    		
    		for (int i = 1; i <= M; i++) {
    			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
    		}
    		
    		if (sum[M] < K) cnt++;
    		
    		if (N != M) {
	    		for (int i = M + 1; i <= N; i++) {
	    			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
	    			
	    			if (sum[i] - sum[i - M] < K) cnt++;
	    		}
	    		
	    		for (int i = 1; i < M; i++) {
	    			if (sum[N] - sum[N - M + i] + sum[i] < K) cnt++; 
	    		}
    		}
    		
    		sb.append(cnt).append("\n");
    	}
    	
    	System.out.println(sb);
    	
        br.close();
    }
}