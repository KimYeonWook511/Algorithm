import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String input = br.readLine();
			int len = input.length();
			
			boolean bit = input.charAt(len - 1) == '1'; // true: 1 false: 0
			int cnt = 0;
			
			for (int i = len - 2; i >= 0; i--) {
				if (input.charAt(i) == '1' && bit) continue;
				if (input.charAt(i) == '0' && !bit) continue;
				
				bit = !bit;
				cnt++;
			}
			
			sb.append("#").append(t).append(" ").append(bit ? cnt + 1 : cnt).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}