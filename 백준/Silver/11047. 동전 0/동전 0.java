import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coin[] = new int[n + 1];
		int idx = n;
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			int c = Integer.parseInt(br.readLine());
			
			if (c > k) {
				idx = i - 1;
				break;
			}
			
			coin[i] = c;
		}

		while (k > 0) {
			int temp = k / coin[idx];
			cnt += temp;
			k -= coin[idx] * temp;
			idx--;
		}
		
		System.out.println(cnt);
		
		br.close();
	}
}