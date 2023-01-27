import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	static boolean point[][] = new boolean[201][201];
	static int input[][];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		input = new int[n][2];
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			int kg = Integer.parseInt(st.nextToken());
			int cm = Integer.parseInt(st.nextToken());
			
			point[kg][cm] = true;
			input[run][0] = kg;
			input[run][1] = cm;
		}
		
		for (int i = 0; i < n; i++) {
			int rank = 1;
			
			for (int kg = input[i][0] + 1; kg <= 200; kg++) {
				for (int cm = input[i][1] + 1; cm <= 200; cm++) {
					if (point[kg][cm]) rank++;
				}
			}
			
			bw.write(rank + " ");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}