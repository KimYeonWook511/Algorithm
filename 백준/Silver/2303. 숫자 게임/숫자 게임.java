import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[5];
        int min = 0;
        int idx = 0;
        
        for (int run = 0; run < N; run++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int i = 0; i < 5; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}

        	int max = 0;
        	
        	for (int i = 0; i < 3; i++) {
        		for (int k = i + 1; k < 4; k++) {
        			for (int j = k + 1; j < 5; j++) {
        				max = Math.max(max, (arr[i] + arr[k] + arr[j]) % 10);
        			}
        		}
        	}
        	
        	if (min > max) continue;
        	
    		min = max;
    		idx = run + 1;
        }
        
        System.out.println(idx);
        
        br.close();
    }
}