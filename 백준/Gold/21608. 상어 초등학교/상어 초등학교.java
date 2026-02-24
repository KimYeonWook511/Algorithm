import java.io.*;
import java.util.*;

public class Main {
    static final int POW[] = {0, 1, 10, 100, 1000};
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int nums[] = new int[N * N];
        boolean likes[][] = new boolean[N * N + 1][N * N + 1];
        for (int i = 0; i < nums.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;

            for (int k = 0; k < 4; k++) {
                int target = Integer.parseInt(st.nextToken());
                likes[num][target] = true;
            }
        }

        int map[][] = new int[N][N];
		for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
			int like = -1;
			int blank = -1;
			int row = -1;
			int col = -1;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] != 0) continue;

					int likeCount = 0;
					int blankCount = 0;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (nr < 0 || nc < 0) continue;
						if (nr >= N || nc >= N) continue;

						if (map[nr][nc] == 0) {
							blankCount++;
						} else if (likes[num][map[nr][nc]]) {
							likeCount++;
						}
					}

					if (likeCount > like) {
						like = likeCount;
						blank = blankCount;
						row = r;
						col = c;
					} else if (likeCount == like && blankCount > blank) {
						blank = blankCount;
						row = r;
						col = c;
					}
				}
			}
			map[row][col] = num;
		}

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nc < 0) continue;
                    if (nr >= N || nc >= N) continue;

                    if (likes[map[r][c]][map[nr][nc]]) {
                        count++;
                    }
                }
                answer += POW[count];
            }
        }

        System.out.println(answer);

        br.close();
    }
}