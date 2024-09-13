import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N + 1][2];
        int idx = 1;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	int size = Integer.parseInt(st.nextToken()) + i;
        	
        	if (size <= arr[idx - 1][0]) continue;
        	
        	arr[idx][0] = size;
        	arr[idx][1] = i + 1;
        	idx++;
        }
        
        int Q = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
        	int size = Integer.parseInt(st.nextToken());
        	
        	int left = 1;
        	int right = idx - 1;
        	
        	while (left <= right) {
        		int mid = (left + right) >> 1;
        	
        		if (size > arr[mid][0]) left = mid + 1;
        		else right = mid - 1;
        	}
        	
        	sb.append(arr[left][1]).append(" ");
        }
        
        System.out.println(sb);
        
        br.close();
    }
}