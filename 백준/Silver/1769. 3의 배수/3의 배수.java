import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		String x = br.readLine();
		int cnt = 0;
		
		while (x.length() > 1) {
			int sum = 0;
			
			for (int i = 0; i < x.length(); i++) {
				sum += x.charAt(i) - '0';
			}
			
			x = Integer.toString(sum);
			cnt++;
		}
		
		bw.write(cnt + "\n");
		bw.write(Integer.parseInt(x)% 3 == 0 ? "YES" : "NO");
		
		br.close();
		bw.close();
	}
}