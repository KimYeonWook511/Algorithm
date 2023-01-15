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
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			boolean alphabet[] = new boolean[26];
			
			for (int idx = 0; idx < word.length(); idx++) {
				if (alphabet[word.charAt(idx) - 97]) {
					cnt--;
					break;
				}
				
				if (idx == word.length() - 1) {
					break;
				}
				
				if (word.charAt(idx) != word.charAt(idx + 1)) {
					alphabet[word.charAt(idx) - 97] = true;
				}
			}
			
			cnt++;
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();

		br.close();
		bw.close();
	}
}