import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine().toUpperCase();
		int alphabet[] = new int[26];
		
		for (int i = 0; i < input.length(); i++) {
			alphabet[input.charAt(i) - 65] += 1;
		}
		
		int maxCnt = 0;
		char maxAlphabet = ' ';
		
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] > maxCnt) {
				maxCnt = alphabet[i];
				maxAlphabet = (char)(i + 65);
				
			} else if (alphabet[i] == maxCnt) {
				maxAlphabet = '?';
				
			}
		}
		
		bw.write(maxAlphabet);
		bw.flush();

		br.close();
		bw.close();
	}
}