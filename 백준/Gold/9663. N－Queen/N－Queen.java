import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int T, N, arr[], cnt;
	static boolean colChk[], crossChk[][];
	
	public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N]; // 행은 배제(놓는 순서대로 행 순서라는 가정)
    	colChk = new boolean[N];
    	crossChk = new boolean[2][N << 1]; // 좌상, 우상  | 우하, 좌하 (시계방향) -> 아래는 고려할 필요 없음
    	
    	for (int c = 0; c < N; c++) {
    		colChk[c] = true;
    		crossChk[0][N - (c + 1)] = true; // 좌상
    		crossChk[1][N - (N - c)] = true; // 우상
    		arr[0] = c;
    		func(1);
    		colChk[c] = false;
    		crossChk[0][N - (c + 1)] = false;
    		crossChk[1][N - (N - c)] = false;
    	}
        	
        System.out.println(cnt);

        br.close();
    }
	
	static void func(int r) {
		if (r == N) {
			cnt++;
			
			return;
		}
		
		for (int c = 0; c < N; c++) {
			if (colChk[c]) continue; // 열 체크
			if (crossChk[0][(N + r) - (c + 1)] || crossChk[1][(N + r) - (N - c)]) continue; // 대각선 체크

			colChk[c] = true;
			crossChk[0][(N + r) - (c + 1)] = true; // 좌상
			crossChk[1][(N + r) - (N - c)] = true; // 우상
			arr[r] = c;
			func(r + 1);
			colChk[c] = false;
			crossChk[0][(N + r) - (c + 1)] = false;
			crossChk[1][(N + r) - (N - c)] = false;
		}
	}
}