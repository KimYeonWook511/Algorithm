import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		int alphabet[] = new int[26];
		char result[] = new char[str.length()];
		int idx = 0;
		boolean flag = true;
		
		for (int i = 0; i < str.length(); i++) {
			alphabet[str.charAt(i) - 'A']++;
		}

		for (int i = 0; i < 26; i++) {
			while (alphabet[i] > 1) {
				result[idx] = result[str.length() - 1 - idx] = (char)('A' + i);
				idx++;
				alphabet[i] -= 2;
			}
			
			if (alphabet[i] == 1) {
				if (result[str.length() / 2] != 0) {
					flag = false;
					break;
				}
				
				result[str.length() / 2] = (char)('A' + i);
			}
		}
		
		if (flag) {
			for (int i = 0; i < str.length(); i++) {
				System.out.print(result[i]);
			}
			
		} else {
			System.out.println("I'm Sorry Hansoo");
		}
		
		br.close();
	}
}