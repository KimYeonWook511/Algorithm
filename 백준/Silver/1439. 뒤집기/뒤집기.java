import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String s = br.readLine();
		int zeroCnt = 0;
		int oneCnt = 0;
		
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				if (s.charAt(i - 1) == '0') zeroCnt++;
				else oneCnt++;
			}
		}
		
		if (s.charAt(s.length() - 1) == '0') zeroCnt++;
		else oneCnt++;
		
		System.out.println(Math.min(zeroCnt, oneCnt));
		
		br.close();
	}
}