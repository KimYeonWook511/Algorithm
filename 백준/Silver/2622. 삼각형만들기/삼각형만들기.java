import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        int maxI = N / 3;
        
        for (int i = 1; i <= maxI; i++) {
        	int maxK = (N - i) >> 1;
        
        	for (int k = i; k <= maxK; k++) {
        		int val = N - k - i;
        		
        		if (k > val) break;
        		
        		if (val < i + k) cnt++;
        	}
        }
        
		System.out.println(cnt);
        
        br.close();
    }
}