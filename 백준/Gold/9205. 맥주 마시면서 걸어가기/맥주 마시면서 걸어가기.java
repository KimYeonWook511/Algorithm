import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < T; run++) {
			int N = Integer.parseInt(br.readLine());
			
			int arr[][] = new int[N + 2][2];
			Deque<Integer> deque = new ArrayDeque<>();
			boolean chk[] = new boolean[N + 2];
			
			st = new StringTokenizer(br.readLine());
			arr[0][0] = Integer.parseInt(st.nextToken());
			arr[0][1] = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			arr[N + 1][0] = Integer.parseInt(st.nextToken());
			arr[N + 1][1] = Integer.parseInt(st.nextToken());
			
			boolean flag = false;
			deque.offer(0);
			
			while (!deque.isEmpty()) {
				int cur = deque.poll();
				
				if (Math.abs(arr[cur][0] - arr[N + 1][0]) + Math.abs(arr[cur][1] - arr[N + 1][1]) <= 1000) {
					flag = true;
					break;
				}
				
				for (int i = 1; i <= N; i++) {
					if (chk[i]) continue;
					if (Math.abs(arr[cur][0] - arr[i][0]) + Math.abs(arr[cur][1] - arr[i][1]) > 1000) continue;
					
					chk[i] = true;
					deque.offer(i);
				}
			}
			
			sb.append(flag ? "happy" : "sad").append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}