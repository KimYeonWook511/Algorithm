import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int idx, w;
		
		Point (int idx, int w) {
			this.idx = idx;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int result = N - K;
		
		if (K >= N) {
			int dp[] = new int[100_001];
			PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					return Integer.compare(o1.w, o2.w);
				}
			}); 
			
			for (int i = 0; i <= 100_000; i++) {
				dp[i] = Integer.MAX_VALUE;
			}
			
			dp[N] = 0;
			pq.offer(new Point(N, 0));
			
			while (!pq.isEmpty()) {
				Point cur = pq.poll();
				
				if (cur.idx == K) {
					result = cur.w;
					break;
				}
				
				if ((cur.idx << 1) <= 100_000 && dp[cur.idx << 1] > cur.w) {
					dp[cur.idx << 1] = cur.w;
					pq.offer(new Point(cur.idx << 1, cur.w));
				}
				
				if (cur.idx - 1 >= 0 && dp[cur.idx - 1] > cur.w + 1) {
					dp[cur.idx - 1] = cur.w + 1;
					pq.offer(new Point(cur.idx - 1, cur.w + 1));
				}
				
				if (cur.idx + 1 <= 100_000 && dp[cur.idx + 1] > cur.w + 1) {
					dp[cur.idx + 1] = cur.w + 1;
					pq.offer(new Point(cur.idx + 1, cur.w + 1));
				}
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}