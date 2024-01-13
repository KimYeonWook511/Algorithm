import java.io.*;

public class Solution {
	static int N, cnt, nr, nc;
	static boolean arr[][], chk[][];
	static int rVal[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int cVal[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine());

			arr = new boolean[N][N];
			chk = new boolean[N][N];
			cnt = 0;
        	
        	for (int r = 0; r < N; r++) {
        		String str = br.readLine();
        		
        		for (int c = 0; c < N; c++) {
        			if (str.charAt(c) == '.') continue;
        			
					for (int i = 0; i < 8; i++) {
						nr = r + rVal[i];
						nc = c + cVal[i];

						if (nr < 0 || nc < 0) continue;
						if (nr >= N || nc >= N) continue;

						arr[nr][nc] = true;
					}

					arr[r][c] = true;
					cnt--;
        		}
        	}
        	
        	for (int r = 0; r < N; r++) {
        		for (int c = 0; c < N; c++) {
					if (chk[r][c]) continue;

					cnt++;

					if (arr[r][c]) {
						for (int i = 0; i < 8; i++) {
							nr = r + rVal[i];
							nc = c + cVal[i];

							if (nr < 0 || nc < 0) continue;
							if (nr >= N || nc >= N) continue;
							if (arr[nr][nc]) continue;

							cnt--;
							break;
						}

					} else {
						func(r, c);
					}
        		}
    		}
        	
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }

	static void func(int r, int c) {
		if (r < 0 || c < 0) return;
		if (r >= N || c >= N) return;
		if (arr[r][c]) return;
		if (chk[r][c]) return;

		chk[r][c] = true;

		for (int i = 0; i < 8; i++) {
			func(r + rVal[i], c + cVal[i]);
		}
	}
}