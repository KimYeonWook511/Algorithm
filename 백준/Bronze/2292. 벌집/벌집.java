import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		if (n == 1) {
			bw.write("1");
			
		} else {
			int cnt = 1;
			
			while(n > 1) {
				n -= 6 * cnt;
				cnt++;
				
			}
			
			bw.write(Integer.toString(cnt));
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}