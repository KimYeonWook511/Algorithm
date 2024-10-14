import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int arr[][] = new int[n + 1][n + 1];
        int result[][] = new int[n + 1][n + 1];
        
        for (int r = 1; r <= n; r++) {
        	for (int c = 1; c <= n; c++) {
        		arr[r][c] = Integer.MAX_VALUE;
        	}
        	
        	arr[r][r] = 0;
        }
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	arr[a][b] = arr[b][a] = w;
        	result[a][b] = b;
        	result[b][a] = a;
        }
        
        for (int mid = 1; mid <= n; mid++) {
        	for (int start = 1; start <= n; start++) {
        		if (arr[start][mid] == Integer.MAX_VALUE) continue;
        		
        		for (int end = 1; end <= n; end++) {
        			if (arr[mid][end] == Integer.MAX_VALUE) continue;
        			if (arr[start][end] <= arr[start][mid] + arr[mid][end]) continue;
        			
        			arr[start][end] = arr[start][mid] + arr[mid][end];
        			
        			result[start][end] = mid;
        			int tempMid = mid;
        			
        			while (true) {
        				if (result[start][tempMid] == tempMid) break;
        				
        				result[start][end] = result[start][tempMid];
        				tempMid = result[start][end];
        			}
        		}
        	}
        }
        
        for (int start = 1; start <= n; start++) {
        	for (int end = 1; end <= n; end++) {
        		sb.append(result[start][end] == 0 ? "- " : result[start][end] + " ");
        	}
        	sb.append("\n");
        }

        System.out.println(sb);
        
        br.close();
    }
}