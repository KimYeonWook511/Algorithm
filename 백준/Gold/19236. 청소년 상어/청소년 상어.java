import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r, c;
		int d;

		Node (int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static final int SIZE = 4;
	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, -1, -1, -1, 0, 1, 1, 1};

	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node fishes[] = new Node[17]; // 1~16
		int map[][] = new int[SIZE][SIZE];

		for (int r = 0; r < SIZE; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < SIZE; c++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				map[r][c] = a;
				fishes[a] = new Node(r, c, b - 1);
			}
		}

		int num = map[0][0];
		map[0][0] = -1;
		Node shark = new Node(0, 0, fishes[num].d);

		func(fishes, map, num, shark, 1 << num);

		System.out.println(answer);

		br.close();
	}

	static void func(Node fishes[], int map[][], int sum, Node shark, int checkBit) {
		answer = Math.max(answer, sum);

		// 상어 움직일 수 있는지 확인
		if (!canMove(shark.r + dr[shark.d], shark.c + dc[shark.d])) return;

		// 물고기 움직이기
		Node copyFishes[] = copy(fishes);
		int copyMap[][] = copy(map);
		moveFish(copyFishes, copyMap, checkBit);

		// 상어 움직이기 (물고기 먹기)
		for (int dd = 1; dd <= 3; dd++) {
			int nr = shark.r + (dr[shark.d] * dd);
			int nc = shark.c + (dc[shark.d] * dd);

			if (canMove(nr, nc) && copyMap[nr][nc] != 0) {
				int targetNum = copyMap[nr][nc];
				Node target = copyFishes[targetNum];

				copyMap[shark.r][shark.c] = 0;
				copyMap[nr][nc] = -1;
				Node copyShark = new Node(nr, nc, target.d);
				func(copyFishes, copyMap, sum + targetNum, copyShark, checkBit | (1 << targetNum));
				copyMap[shark.r][shark.c] = -1;
				copyMap[nr][nc] = targetNum;
			}
		}
	}

	static void moveFish(Node fishes[], int map[][], int checkBit) {
		for (int i = 1; i < fishes.length; i++) {
			if ((checkBit & (1 << i)) != 0) continue;

			Node fish = fishes[i];
			int r = fish.r;
			int c = fish.c;
			while (true) {
				int nr = r + dr[fish.d];
				int nc = c + dc[fish.d];

				if (!canMove(nr, nc) || map[nr][nc] == -1) {
					fish.d = (fish.d + 1) % 8;
					continue;
				}

				if (map[nr][nc] > 0) {
					Node target = fishes[map[nr][nc]];
					target.r = r;
					target.c = c;
				}
				fish.r = nr;
				fish.c = nc;
				map[r][c] = map[nr][nc];
				map[nr][nc] = i;
				break;
			}
		}
	}

	static boolean canMove(int r, int c) {
		return (r >= 0 && c >= 0 && r < SIZE && c < SIZE);
	}

	static Node[] copy(Node arr[]) {
		Node copy[] = new Node[arr.length];
		for (int i = 1; i < arr.length; i++) {
			copy[i] = new Node(arr[i].r, arr[i].c, arr[i].d);
		}
		return copy;
	}

	static int[][] copy(int arr[][]) {
		int copy[][] = new int[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				copy[r][c] = arr[r][c];
			}
		}
		return copy;
	}
}