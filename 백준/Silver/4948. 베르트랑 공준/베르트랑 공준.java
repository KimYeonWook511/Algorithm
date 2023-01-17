import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 0) break;
			
			int cnt = 0;
			boolean arr[] = new boolean[2 * n]; // 소수가 아닌건 true
			arr[0] = true; // 숫자 1은 소수가 아님
			
			for (int num = 2; num <= 2 * n; num++) {
				if (arr[num - 1]) continue;
				
				for (int i = 2; num * i <= 2 * n; i++) {
					arr[num * i - 1] = true;
				}
			}
			
			for (int i = n + 1; i <= 2 * n; i++) {
				if (!arr[i - 1]) cnt++;
			}
			
			bw.write(cnt + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
