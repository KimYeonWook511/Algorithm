import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arrDice = new int[6];
		
		while (st.hasMoreTokens()) {
			arrDice[Integer.parseInt(st.nextToken()) - 1] += 1;
		}
		
		int cnt = 0;
		for (int i = 0; i < arrDice.length; i++) {
			
			if (arrDice[i] == 3) {
				bw.write(Integer.toString(10000 + (i + 1) * 1000));
				
			} else if (arrDice[i] == 2) {
				bw.write(Integer.toString(1000 + (i + 1) * 100));
				
			} else if (arrDice[i] == 1 && cnt == 2) {
				bw.write(Integer.toString((i + 1) * 100));
				
			} else if (arrDice[i] == 1 && cnt != 2) {
				cnt++;
				
			}
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
