import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		String doc = br.readLine();
		String word = br.readLine();
		int idx = 0;
		int result = 0;
		
		while (idx + word.length() <= doc.length()) {
			if (doc.substring(idx, word.length() + idx).equals(word)) {
				result++;
				idx += word.length();
				
			} else {
				idx++;
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}