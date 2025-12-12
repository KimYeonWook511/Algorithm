import java.io.*;
import java.util.*;

public class Main {
	static class Tree {
		int x, y, l;

		Tree (int x, int y, int l) {
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Tree trees[] = new Tree[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			trees[i] = new Tree(x, y, l);
		}

		Arrays.sort(trees, new Comparator<Tree>() {
			@Override
			public int compare(Tree o1, Tree o2) {
				return -Integer.compare(o1.l, o2.l);
			}
		});

		int answer = N;
		for (int l = 0; l < N; l++) {
			for (int r = l; r < N; r++) {
				int left = trees[l].x;
				int right = trees[r].x;
				if (left > right) {
					left = trees[r].x;
					right = trees[l].x;
				}

				for (int d = 0; d < N; d++) {
					for (int u = d; u < N; u++) {
						int down = trees[d].y;
						int up = trees[u].y;
						if (down > up) {
							down = trees[u].y;
							up = trees[d].y;
						}

						int val = (right - left) * 2 + (up - down) * 2; // 울타리 둘레
						int cnt = 0;
						int len = 0;
						// 울타리 외부 나무 계산
						for (int i = 0; i < N; i++) {
							Tree cur = trees[i];
							if (cur.x < left || cur.x > right || cur.y < down || cur.y > up) {
								len += cur.l;
								cnt++;
							}
						}

						// 울타리 외부 나무로 충분
						if (len >= val) {
							answer = Math.min(answer, cnt);
							continue;
						}

						// 길이 부족
						for (int i = 0; i < N; i++) {
							Tree cur = trees[i];
							if (cur.x >= left && cur.x <= right && cur.y >= down && cur.y <= up) {
								len += cur.l;
								cnt++;
								if (len >= val) {
									answer = Math.min(answer, cnt);
									break;
								}
							}
						}
					}
				}
			}
		}

		System.out.println(answer);

		br.close();
	}
}