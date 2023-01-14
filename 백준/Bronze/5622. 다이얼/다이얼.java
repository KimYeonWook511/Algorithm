import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		int cnt = 0;
		
		for (int i = 0; i < input.length(); i++) {
			char alphabet = input.charAt(i);
			
			if (alphabet < 68)	cnt += 3;
			else if (alphabet < 71)	cnt += 4;
			else if (alphabet < 74) cnt += 5;
			else if (alphabet < 77) cnt += 6;
			else if (alphabet < 80) cnt += 7;
			else if (alphabet < 84) cnt += 8;
			else if (alphabet < 87) cnt += 9;
			else if (alphabet < 91) cnt += 10;
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();

		br.close();
		bw.close();
	}
}