import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			int n = Integer.parseInt(br.readLine());
			
			boolean arr[] = new boolean[n];
			
			for (int num = 2; num <= n; num++) {
				if (arr[num - 2]) continue;
				
				for (int i = 2; num * i <= n; i++) {
					arr[num * i - 2] = true;
				}
			}
			
			for (int i = n / 2; i > 1; i--) {
				if (!arr[i - 2] && !arr[n - i - 2]) {
					bw.write(i + " " + (n - i) + "\n");
					break;
				}
			}
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
