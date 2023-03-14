import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int alphabet[] = new int[26];
		
		for (int run = 0; run < n; run++) {
			alphabet[br.readLine().charAt(0) - 'a']++;
		}
		
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] == 0) continue;
			
			if (alphabet[i] >= 5) bw.write(i + 'a');
			else n -= alphabet[i];
		}
		
		if (n == 0) bw.write("PREDAJA");
		
		bw.flush();

		br.close();
		bw.close();
	}
}