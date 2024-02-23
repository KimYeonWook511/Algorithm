import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[][], select[], max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][9];
		select = new int[9];
		
		for (int innings = 0; innings < N; innings++) {
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 9; i++) {
				arr[innings][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		select[3] = 0;
		func(0, 1);
		
		System.out.println(max);
		
		br.close();
	}
	
	static void func(int idx, int bit) {
		if (idx == 3) {
			func(idx + 1, bit);
			
			return;
		}
		
		if (idx == 9) {
			play(0, 0, 0);
			
			return;
		}
		
		for (int i = 1; i < 9; i++) {
			if ((bit & (1 << i)) != 0) continue;
			
			select[idx] = i;
			func(idx + 1, bit | (1 << i));
		}
	}
	
	static void play(int innings, int idx, int sum) {
		if (innings == N) {
			max = Math.max(max, sum);
			
			return;
		}
		
		int out = 0;
		int baseBit = 0;
		
		while (out < 3) {
			if (arr[innings][select[idx]] == 4) {
				sum++;
				if ((baseBit & (1 << 1)) != 0) sum++;
				if ((baseBit & (1 << 2)) != 0) sum++;
				if ((baseBit & (1 << 3)) != 0) sum++;
				
				baseBit = 0;
				
			} else if (arr[innings][select[idx]] == 0) {
				out++;
				
			} else {
				baseBit = (baseBit + 1) << arr[innings][select[idx]];

				if ((baseBit & (1 << 4)) != 0) sum++;
				if ((baseBit & (1 << 5)) != 0) sum++;
				if ((baseBit & (1 << 6)) != 0) sum++;
				
				baseBit &= 14; // 14 -> 1110
			}
			
			idx = (idx + 10) % 9;
		}
		
		play(innings + 1, idx, sum);
	}
}