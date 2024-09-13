import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int sumA[] = new int[m + 1];
        int sumB[] = new int[n + 1];
    	int cntA[] = new int[2_000_001];
    	int cntB[] = new int[2_000_001];
        
        for (int i = 1; i <= m; i++) {
        	sumA[i] = sumA[i - 1] + Integer.parseInt(br.readLine());
        	cntA[sumA[i] - sumA[i - 1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
        	sumB[i] = sumB[i - 1] + Integer.parseInt(br.readLine());
        	cntB[sumB[i] - sumB[i - 1]]++;
        }
        
        for (int len = Math.max(m, n); len >= 2; len--) {
        	for (int i = Math.max(m, n); i >= len; i--) {
        		if (i <= m) cntA[sumA[i] - sumA[i - len]]++;
        		if (i <= n) cntB[sumB[i] - sumB[i - len]]++;
        	}
        	
        	for (int i = 1; i < len; i++) {
        		if (len < m) cntA[sumA[m] - sumA[m - len + i] + sumA[i]]++;
        		if (len < n) cntB[sumB[n] - sumB[n - len + i] + sumB[i]]++;
        	}
        }
        
        int result = cntA[num] + cntB[num];
        for (int i = 0; i <= num; i++) {
        	result += cntA[i] * cntB[num - i];
        }
        
        System.out.println(result);
        
        br.close();
    }
}