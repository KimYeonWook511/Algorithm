import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			String oxResult = br.readLine();
			int cnt = 0;
			int grade = 0;
			
			for (int idx = 0; idx < oxResult.length(); idx++) {
				if (Character.toString(oxResult.charAt(idx)).equals("O")) {
					cnt++;
					grade += cnt;
					
				} else {
					cnt = 0;
					
				}
			}
			bw.write(grade + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
