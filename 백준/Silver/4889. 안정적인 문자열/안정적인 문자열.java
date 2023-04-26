import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int run = 0;
		
		while (run++ > -1) {
			String str = br.readLine();
			int cnt = 0;
			int flag = 1;
			
			if (str.equals("")) {
				bw.write(run + ". 0\n");
				continue;
			}
			
			if (str.charAt(0) == '-') break;
			
			if (str.charAt(0) == '}') cnt++;
			
			if (str.charAt(str.length() - 1) == '{') cnt++;
			
			for (int i = 1; i < str.length() - 1; i++) {
				if (str.charAt(i) == '{') {
					flag++;
					
				} else if (flag == 0) {
					cnt++;
					flag++;
					
				} else {
					flag--;
				}
			}
			
			bw.write(run + ". " + (cnt + --flag / 2) + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
