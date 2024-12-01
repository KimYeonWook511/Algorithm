import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
		}

		int result = 0;
		while (!pq.isEmpty()) {
			int a1 = pq.poll();

			if (pq.isEmpty()) {
				result += a1;
				break;
			}

			int a2 = pq.poll();
			result += a2;

			pq.offer(a1 - a2);
		}

        System.out.println(result > 1440 ? -1 : result);

        br.close();
    }
}