import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int arr[] = new int[N];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	min = Math.min(min, arr[i]);
        }
        
        long left = 0;
        long right = 1_000_000_000L * min; // 10억 * 10억으로 하면 val += mid / arr[i]시 오버플로우 생길 수 있음!
        
        while (left <= right) {
        	long mid = (left + right) >> 1;
        	long val = 0;
        
        	for (int i = 0; i < N; i++) {
        		val += mid / arr[i];
        	}
        	
        	if (val < M) left = mid + 1;
        	else right = mid - 1;
        }

        System.out.println(left);
        
        br.close();
    }
}