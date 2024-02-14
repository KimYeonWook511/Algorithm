import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N, end, cnt = -1;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		end = N / 3;
		
		for (int i = 0; i <= end; i++) {
			if ((N - 3 * i) % 5 != 0) continue;
			
			cnt = i + (N - 3 * i) / 5;
			break;
		}
		
		System.out.println(cnt);
		
		br.close();
	}
}