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
		String pattern[] = br.readLine().split("\\*");
		
		for (int run = 0; run < n; run++) {
			String file = br.readLine();
			
			bw.write(file.length() >= pattern[0].length() + pattern[1].length()
					&& file.substring(0, pattern[0].length()).equals(pattern[0]) 
					&& file.substring(file.length() - pattern[1].length()).equals(pattern[1]) ? "DA\n" : "NE\n");
		}
		
		br.close();
		bw.close();
	}
}