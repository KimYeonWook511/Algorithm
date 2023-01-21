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
		
		for (int run = 0; run < n; run++) {
			bw.write(isPalindrome(br.readLine()) + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
	
	static String isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}
	
	static String recursion(String s, int left, int right) {
		if (left >= right) return 1 + " " + (left + 1);
		else if (s.charAt(left) != s.charAt(right)) return 0 + " " + (left + 1);
		else return recursion(s, left + 1, right - 1);
	}
}