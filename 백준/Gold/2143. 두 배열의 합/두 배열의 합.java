import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        int sum[];
        
        int n = Integer.parseInt(br.readLine());
        sum = new int[n + 1];
        Map<Integer, Long> mapA = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
        	sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
        	
        	for (int s = 0; s < i; s++) {
        		int val = sum[i] - sum[s];
        		
        		mapA.put(val, mapA.getOrDefault(val, 0L) + 1);
        	}
        }
        
        int m = Integer.parseInt(br.readLine());
        sum = new int[m + 1];
        Map<Integer, Long> mapB = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
        	sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];

        	for (int s = 0; s < i; s++) {
        		int val = sum[i] - sum[s];
        		
        		mapB.put(val, mapB.getOrDefault(val, 0L) + 1);
        	}
        }
        
        long result = 0;
        for (Entry<Integer, Long> entry : mapA.entrySet()) {
        	int a = entry.getKey();
        	
        	result += entry.getValue() * mapB.getOrDefault(T - a, 0L); 
        }
        
        System.out.println(result);
        
        br.close();
    }
}