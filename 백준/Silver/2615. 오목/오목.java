import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][], N = 19;
	static int row, col, temp;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("Test5.txt"));
		//여기에 코드를 작성하세요.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[N + 1][N + 1];
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 1; c <= N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		flag : for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (arr[r][c] != 0) {
//					if (up(r, c)) break flag;
					if (down(r, c)) break flag;
//					if (left(r, c)) break flag;
					if (right(r, c)) break flag;
					
//					if (crossUpLeft(r, c)) break flag;
//					if (crossUpRight(r, c)) break flag;
					if (crossDownLeft(r, c)) break flag;
					if (crossDownRight(r, c)) break flag;
				}
			}
		}
		
		System.out.println(temp);
		
		if (temp != 0) System.out.println(row + " " + col); 
		
		br.close();
	}
	
//	static boolean up(int r, int c) {
//		// 6돌 체크
//		if (r + 1 <= N && arr[r + 1][c] == arr[r][c]) return false;
//		if (r - 5 > 0 && arr[r - 5][c] == arr[r][c]) return false;
//		
//		int cnt = 1;
//		
//		for (int i = 1; i < 5; i++) {
//			if (r - i < 1) break;
//			if (arr[r - i][c] == arr[r][c]) cnt++; 
//		}
//		
//		if (cnt == 5) {
//			row = r - 4;
//			col = c;
//			temp = arr[r][c];
//			return true;
//		}
//		
//		return false;
//	}
	
	static boolean down(int r, int c) {
		// 6돌 체크
		if (r - 1 > 0 && arr[r - 1][c] == arr[r][c]) return false;
		if (r + 5 <= N && arr[r + 5][c] == arr[r][c]) return false;
		
		int cnt = 1;
		
		for (int i = 1; i < 5; i++) {
			if (r + i > N) break;
			if (arr[r + i][c] == arr[r][c]) cnt++; 
		}
		
		if (cnt == 5) {
			row = r;
			col = c;
			temp = arr[r][c];
			return true;
		}
		
		return false;
	}
	
//	static boolean left(int r, int c) {
//		// 6돌 체크
//		if (c + 1 <= N && arr[r][c + 1] == arr[r][c]) return false;
//		if (c - 5 > 0 && arr[r][c - 5] == arr[r][c]) return false;
//		
//		int cnt = 1;
//		
//		for (int i = 1; i < 5; i++) {
//			if (c - i < 1) break;
//			if (arr[r][c - i] == arr[r][c]) cnt++; 
//		}
//		
//		if (cnt == 5) {
//			row = r;
//			col = c - 4;
//			temp = arr[r][c];
//			return true;
//		}
//		
//		return false;
//	}
	
	static boolean right(int r, int c) {
		// 6돌 체크
		if (c - 1 > 0 && arr[r][c - 1] == arr[r][c]) return false;
		if (c + 5 <= N && arr[r][c + 5] == arr[r][c]) return false;
		
		int cnt = 1;
		
		for (int i = 1; i < 5; i++) {
			if (c + i > N) break;
			if (arr[r][c + i] == arr[r][c]) cnt++; 
		}
		
		if (cnt == 5) {
			row = r;
			col = c;
			temp = arr[r][c];
			return true;
		}
		
		return false;
	}
	
//	static boolean crossUpLeft(int r, int c) {
//		// 6돌 체크
//		if (r + 1 <= N && c + 1 <= N && arr[r + 1][c + 1] == arr[r][c]) return false;
//		if (r - 5 > 0 && c - 5 > 0 && arr[r - 5][c - 5] == arr[r][c]) return false;
//		
//		int cnt = 1;
//		
//		for (int i = 1; i < 5; i++) {
//			if (r - i < 1 || c - i < 1) break;
//			if (arr[r - i][c - i] == arr[r][c]) cnt++; 
//		}
//		
//		if (cnt == 5) {
//			row = r - 4;
//			col = c - 4;
//			temp = arr[r][c];
//			return true;
//		}
//		
//		return false;
//	}
	
//	static boolean crossUpRight(int r, int c) {
//		// 6돌 체크
//		if (r + 1 <= N && c - 1 > 0 && arr[r + 1][c - 1] == arr[r][c]) return false;
//		if (r - 5 > 0 && c + 5 <= N && arr[r - 5][c + 5] == arr[r][c]) return false;
//		
//		int cnt = 1;
//		
//		for (int i = 1; i < 5; i++) {
//			if (r - i < 1 || c + i > N) break;
//			if (arr[r - i][c + i] == arr[r][c]) cnt++; 
//		}
//		
//		if (cnt == 5) {
//			row = r;
//			col = c;
//			temp = arr[r][c];
//			return true;
//		}
//		
//		return false;
//	}
	
	static boolean crossDownLeft(int r, int c) {
		// 6돌 체크
		if (r - 1 > 0 && c + 1 <= N && arr[r - 1][c + 1] == arr[r][c]) return false;
		if (r + 5 <= N && c - 5 > 0 && arr[r + 5][c - 5] == arr[r][c]) return false;
		
		int cnt = 1;
		
		for (int i = 1; i < 5; i++) {
			if (r + i > N || c - i < 1) break;
			if (arr[r + i][c - i] == arr[r][c]) cnt++; 
		}
		
		if (cnt == 5) {
			row = r + 4;
			col = c - 4;
			temp = arr[r][c];
			return true;
		}
		
		return false;
	}
	
	static boolean crossDownRight(int r, int c) {
		// 6돌 체크
		if (r - 1 > 0 && c - 1 > 0 && arr[r - 1][c - 1] == arr[r][c]) return false;
		if (r + 5 <= N && c + 5 <= N && arr[r + 5][c + 5] == arr[r][c]) return false;
		
		int cnt = 1;
		
		for (int i = 1; i < 5; i++) {
			if (r + i > N || c + i > N) break;
			if (arr[r + i][c + i] == arr[r][c]) cnt++; 
		}
		
		if (cnt == 5) {
			row = r;
			col = c;
			temp = arr[r][c];
			return true;
		}
		
		return false;
	}
}