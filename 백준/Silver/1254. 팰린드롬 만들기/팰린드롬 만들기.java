import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		int left = (str.length() - 1) / 2;
		int right = str.length() / 2;
		int cnt = 0;
		
		for (int i = 0; i + right < str.length(); i++) {
			if (str.charAt(left - i) != str.charAt(right + i)) {
				cnt++;
				left = (str.length() + cnt - 1) / 2;
				right = (str.length() + cnt) / 2;
				i = -1;
			}
		}
		
		System.out.println(str.length() + cnt);
		
		br.close();
	}
}