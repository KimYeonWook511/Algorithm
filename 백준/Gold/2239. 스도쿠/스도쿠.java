import java.io.*;

public class Main {
	static int arr[][];
	static int chkR[] = new int[10], chkC[] = new int[10], chkS[] = new int[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		arr = new int[10][10];
		
		for (int r = 1; r < 10; r++) {
			String line = br.readLine();
			
			for (int c = 1; c < 10; c++) {
				arr[r][c] = line.charAt(c - 1) - '0';
				
				if (arr[r][c] != 0) {
					// on
					chkR[r] |= (1 << arr[r][c]);
					chkC[c] |= (1 << arr[r][c]);
					chkS[search(r, c)] |= (1 << arr[r][c]);
				}
			}
		}
		
		func(0);
		
		for (int r = 1; r < 10; r++) {
			for (int c = 1; c < 10; c++) {
				sb.append(arr[r][c]);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static boolean func(int x) {
		if (x > 80) {
			// 다 도달 함
			return true;
		}
		
		int r = (x / 9) + 1;
		int c = (x % 9) + 1;
		int s = search(r, c);
		
		if (arr[r][c] != 0) return func(x + 1);
		
		for (int i = 1; i < 10; i++) {
			if ((chkR[r] & (1 << i)) != 0) continue;
			if ((chkC[c] & (1 << i)) != 0) continue;
			if ((chkS[s] & (1 << i)) != 0) continue;
			
			// on
			chkR[r] |= (1 << i);
			chkC[c] |= (1 << i);
			chkS[s] |= (1 << i);
//			chkR[r] += (1 << i);
//			chkC[c] += (1 << i);
//			chkS[s] += (1 << i);
			
			if (func(x + 1)) {
				arr[r][c] = i;
				return true;
			}
			
			// off
			chkR[r] -= (1 << i);
			chkC[c] -= (1 << i);
			chkS[s] -= (1 << i);
		}
		
		return false;
	}
	
	static int search(int r, int c) {
		if (r <= 3) {
			if (c <= 3) return 1;
			else if (c <= 6) return 2; 
			else return 3;
			
		} else if (r <= 6) {
			if (c <= 3) return 4;
			else if (c <= 6) return 5; 
			else return 6;
			
		} else {
			if (c <= 3) return 7;
			else if (c <= 6) return 8; 
			else return 9;
		}
	}
}