import java.io.*;
import java.util.*;

public class Main {
	static class Box {
		int num;
		int w, h, kg;
		
		public Box(int num, int w, int h, int kg) {
			this.num = num;
			this.w = w;
			this.h = h;
			this.kg = kg;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Box arr[] = new Box[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i] = new Box(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
			
		Arrays.sort(arr, new Comparator<Box>() {
			@Override
			public int compare(Box o1, Box o2) {
				return -Integer.compare(o1.w, o2.w);
			}
		});
		
		int h[] = new int[N];
		
		for (int r = 0; r < N; r++) {
			h[r] = arr[r].h;
			
			for (int c = 0; c < r; c++) {
				if (arr[r].kg < arr[c].kg) h[r] = Math.max(h[r], h[c] + arr[r].h);
			}
		}
		
		int max = 0;
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			if (h[i] <= max) continue;
			
			max = h[i];
			idx = i;
		}
		
		int cnt = 0;
		idx++;
		
		while (--idx >= 0) {
			if (h[idx] != max) continue;
			
			sb.append(arr[idx].num).append("\n");
			max -= arr[idx].h;
			cnt++;
		}
		
		System.out.println(cnt);
		System.out.println(sb);
		
		br.close();
	}
}