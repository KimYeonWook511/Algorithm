import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean arr[] = new boolean[n]; // 소수가 아닌건 true
		arr[0] = true; // 숫자 1은 소수가 아님
		
		for (int num = 2; num <= n; num++) {
			if (arr[num - 1]) continue;
			
			for (int i = 2; num * i <= n; i++) {
				arr[num * i - 1] = true;
			}
		}
		
		for (int i = m; i <= n; i++) {
			if (!arr[i - 1]) bw.write(i + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
