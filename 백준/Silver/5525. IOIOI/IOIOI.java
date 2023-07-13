import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int idx = 0;
		int result = 0;
		
		while (idx < m - 1) {
			if (s.charAt(idx++) == 'I') {
				int cnt = 0;
				
				while (true) {
					if (idx == m) {
						break;
						
					} else if (cnt % 2 == 0 && s.charAt(idx) == 'O') {
						idx++;
						cnt++;
						
					} else if (cnt % 2 == 1 && s.charAt(idx) == 'I') {
						idx++;
						cnt++;
						
						if (cnt == 2 * n) {
							result++;
							cnt -= 2;
						}
						
					} else {
						break;
					}
				}
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}