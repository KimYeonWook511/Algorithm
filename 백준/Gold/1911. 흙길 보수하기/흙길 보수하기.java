import java.io.*;
import java.util.*;

public class Main {
	static class Pool {
		int start, end;
		
		Pool (int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		PriorityQueue<Pool> pq = new PriorityQueue<>(new Comparator<Pool>() {
			@Override
			public int compare(Pool o1, Pool o2) {
				if (o1.start == o2.start) return Integer.compare(o1.end, o2.end);
				
				return Integer.compare(o1.start, o2.start);
			}
		});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			pq.offer(new Pool(start, end));
		}
		
		int lastIdx = -1; // 널빤지의 끝 index
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			Pool cur = pq.poll();
			
			int len = cur.end - Math.max(cur.start, lastIdx); // 웅덩이 길이
			if (len < 0) continue; // 널빤지 한 개가 여러 웅덩이를 커버하는 경우 
			
			cnt += len / L;
			
			int modCal = len % L; // 넘어가는 널빤지
			if (modCal > 0) {
				cnt++;
				lastIdx = cur.end + (L - modCal);
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}
}