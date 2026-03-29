import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int i;
		boolean isStart;

		Node (int i, boolean isStart) {
			this.i = i;
			this.isStart = isStart;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Node arr[] = new Node[2 * N];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr[idx++] = new Node(s, true);
			arr[idx++] = new Node(e, false);
		}

		Arrays.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.i != o2.i) return Integer.compare(o1.i, o2.i);

				return Boolean.compare(o1.isStart, o2.isStart);
			}
		});

		int answer = 0;
		int cur = 0;
		for (Node node : arr) {
			if (node.isStart) {
				cur++;
				answer = Math.max(answer, cur);
			} else {
				cur--;
			}
		}

		System.out.println(answer);

		br.close();
	}
}