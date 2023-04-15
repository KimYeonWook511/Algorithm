import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		String line = br.readLine();
		int cnt = 0;
		int bar = 0;
		
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '(') {
				cnt++;
				
			} else {
				cnt--;
				
				if (line.charAt(i - 1) == '(') bar += cnt;
				else bar++;
			}
		}
		
		bw.write(Integer.toString(bar));
		
		br.close();
		bw.close();
	}
}