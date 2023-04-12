import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int startIdx = 1;
		int endIdx = 1;
		int cnt = 1;
		int sum = 1;
				
		while (endIdx < n) {
			if (sum == n) {
				cnt++;
				endIdx++;
				sum += endIdx;
				
			} else if (sum < n) {
				endIdx++;
				sum += endIdx;
				
			} else {
				// sum > n
				sum -= startIdx;
				startIdx++;
			}
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();

		br.close();
		bw.close();
	}
}