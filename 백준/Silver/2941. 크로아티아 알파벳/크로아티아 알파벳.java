import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String croatiaAlphabet[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String input = br.readLine();
		int cnt = 0;
		
		for (int i = 0; i < croatiaAlphabet.length; i++) {
			while (input.contains(croatiaAlphabet[i])) {
				input = input.replaceFirst(croatiaAlphabet[i], "#");
				cnt++;
			}
		}
		
		bw.write(Integer.toString(cnt + input.replaceAll("#", "").length()));
		bw.flush();

		br.close();
		bw.close();
	}
}