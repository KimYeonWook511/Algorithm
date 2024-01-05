import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int run = 0; run < T; run++) {
        	int N = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	long max = 0;
        	long cnt = 0;
            long sum = 0;
            long result = 0;
            
            int arr[] = new int[N];
        	
        	for (int i = 0; i < N; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}

        	for (int i = N - 1; i >= 0; i--) {
        		if (arr[i] > max) {
        			result += max * cnt - sum;
        			max = arr[i];
        			cnt = 0;
        			sum = 0;
        			
        		} else {
        			cnt++;
        			sum += arr[i];
        		}
        	}
        	
        	result += max * cnt - sum;
        	
        	sb.append(result).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}