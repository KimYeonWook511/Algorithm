import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		char result[] = new char[str.length()];
		int idx = 0;
		
		while (idx < str.length()) {
			char c = str.charAt(idx);
			
			if (c == '<') {
				result[idx++] = c;
				
				while (true) {
					c = str.charAt(idx);
					
					result[idx++] = c;
					
					if (c == '>') break;
				}
				
			} else if (c == ' ') {
				result[idx++] = c;
				
			} else {
				int startIdx = idx;
				
				while (idx < str.length() && str.charAt(idx) != ' ' && str.charAt(idx) != '<') {
					idx++;
				}
				
				for (int i = 0; i < idx - startIdx; i++) {
					result[idx - i - 1] = str.charAt(startIdx + i);
				}
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			bw.write(result[i]);
		}
		
		br.close();
		bw.close();
	}
}