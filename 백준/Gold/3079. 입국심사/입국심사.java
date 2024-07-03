import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        long left = 0;
        long right = 1_000_000_000L * 1_000_000_000;
        
        while (left <= right) {
        	long mid = (left + right) >> 1;
        	long val = 0;
        
        	for (int i = 0; i < N; i++) {
        		val += mid / arr[i];
        		
        		if (val >= M) break;
        	}
        	
        	if (val < M) left = mid + 1;
        	else right = mid - 1;
        }

        System.out.println(left);
        
        br.close();
    }
}