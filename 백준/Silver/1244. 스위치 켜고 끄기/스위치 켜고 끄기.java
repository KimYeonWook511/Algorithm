import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static boolean bit[];
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		bit = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			bit[i] = st.nextToken().equals("1") ? true : false;
		}

		K = Integer.parseInt(br.readLine());
		int gender = 0;
		int num = 0;
		
		for (int run = 0; run < K; run++) {
			st = new StringTokenizer(br.readLine());
			
			gender = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				man(num);
				
			} else {
				bit[num] = !bit[num];
				woman(num - 1, num + 1);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(bit[i] ? 1 : 0).append(" ");
			
			if (i % 20 == 0) sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static void man(int num) {
		int i = num;
		
		while (i <= N) {
			bit[i] = !bit[i];
			
			i += num;
		}
	}
	
	static void woman(int left, int right) {
		if (left < 1) return;
		if (right > N) return;
		if (bit[left] != bit[right]) return;
		
		bit[left] = !bit[left];
		bit[right] = !bit[right];
		woman(left - 1, right + 1);
	}
}