import java.io.*;
import java.util.*;

public class Main {
	static final long XMAX = 1_000_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		Map<Long, Boolean> map = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			
			map.put(y * XMAX + x, false);
		}

		Deque<long[]> deque = new ArrayDeque<>();
		deque.offer(new long[] {0L, 0L});
		
		long result = -1;
		
		while (!deque.isEmpty()) {
			long cur[] = deque.poll();
			long y = cur[0] / XMAX;
			long x = cur[0] % XMAX;
			long cnt = cur[1];
			
			if (y == T) {
				result = cnt;
				break;
			}
			
			long startX = Math.max(0, x - 2);
			long endX = Math.min(XMAX, x + 2);
			long startY = Math.max(0, y - 2);
			long endY = Math.min(T, y + 2);
			
			for (long nx = startX; nx <= endX; nx++) {
				for (long ny = startY; ny <= endY; ny++) {
					long key = ny * XMAX + nx;
					
					if (!map.containsKey(key)) continue;
					if (map.get(key)) continue;
					
					map.put(key, true);
					deque.offer(new long[] {key, cnt + 1});
				}
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}