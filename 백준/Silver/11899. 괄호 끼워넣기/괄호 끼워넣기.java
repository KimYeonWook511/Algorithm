import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String s = br.readLine();
		int cnt = 0;
		int result = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (c == '(') cnt++;
			else if (cnt > 0) cnt--;
			else result++;
		}
		
		System.out.println(Integer.toString(cnt + result));
		
		br.close();
	}
}