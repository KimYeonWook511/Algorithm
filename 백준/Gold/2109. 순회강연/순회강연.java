import java.io.*;
import java.util.*;

public class Main {
	static class C {
		int p, d;

		C (int p, int d) {
			this.p = p;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<C> pq = new PriorityQueue<>(new Comparator<C>() {
			@Override
			public int compare(C o1, C o2) {
				if (o1.p == o2.p) return -Integer.compare(o1.d, o2.d);

				return -Integer.compare(o1.p, o2.p);
			}
		});
		
		int max = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			max = Math.max(max, d);

			pq.offer(new C(p, d));
		}

		boolean chk[] = new boolean[max + 1];
		C cur;
		int sum = 0;

		while (!pq.isEmpty()) {
			cur = pq.poll();

			for (int day = cur.d; day > 0; day--) {
				if (chk[day]) continue;

				chk[day] = true;
				sum += cur.p;
				break;
			}
		}

		System.out.println(sum);

		br.close();
	}
}