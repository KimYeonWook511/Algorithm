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
		
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int min = 0;
		
		for (int num = n; num >= m; num--) {
			int cnt = 0;
			
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) cnt++;
			}
			
			if (cnt == 2) {
				sum += num;
				min = num;
			}
		}
		
		if (sum == 0) {
			bw.write("-1");
			
		} else {
			bw.write(sum + "\n" + min);
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}