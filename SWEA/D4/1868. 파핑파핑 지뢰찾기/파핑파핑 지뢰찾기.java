import java.io.*;

public class Solution {
	static int N, cnt;
	static boolean arr[][], chk[][];
	static int rVal[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int cVal[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine());

			arr = new boolean[N + 2][N + 2];
			chk = new boolean[N + 2][N + 2];
			cnt = 0;
        	
        	for (int r = 1; r <= N; r++) {
        		String str = br.readLine();
        		
        		for (int c = 1; c <= N; c++) {
        			if (str.charAt(c - 1) == '.') continue;
        			
					for (int i = 0; i < 8; i++) {
						arr[r + rVal[i]][c + cVal[i]] = true;
					}

					arr[r][c] = true;
					cnt--;
        		}
        	}
        	
			for (int i = N + 1; i >= 0; i--) {
				arr[0][i] = true;
				arr[i][0] = true;
				arr[N + 1][i] = true;
				arr[i][N + 1] = true;
			}

        	for (int r = 1; r <= N; r++) {
        		for (int c = 1; c <= N; c++) {
					if (chk[r][c]) continue;

					cnt++;

					if (arr[r][c]) {
						for (int i = 0; i < 8; i++) {
							if (arr[r + rVal[i]][c + cVal[i]]) continue;

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
		if (arr[r][c]) return;
		if (chk[r][c]) return;

		chk[r][c] = true;

		for (int i = 0; i < 8; i++) {
			func(r + rVal[i], c + cVal[i]);
		}
	}
}