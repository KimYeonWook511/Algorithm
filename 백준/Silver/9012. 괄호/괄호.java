import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			String ps = br.readLine();
			int cnt = 0;
			boolean flag = true;
			
			for (int i = 0; i < ps.length(); i++) {
				if (ps.charAt(i) == '(') cnt++;
				else cnt--;
				
				if (cnt < 0) {
					flag = false;
					break;
				}
			}
			
			if (cnt == 0 && flag) bw.write("YES\n");
			else bw.write("NO\n");
		}
		
		br.close();
		bw.close();
	}
}