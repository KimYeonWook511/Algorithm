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
		
		int n = Integer.parseInt(br.readLine());
		
		boolean arr[][] = new boolean[101][101];
		StringTokenizer st;
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = y; i < y + 10; i++) {
				for (int k = x; k < x + 10; k++) {
					arr[i][k] = true; 
				}
			}
		}
		
		int v = 0;
		
		for (int i = 0; i < 101; i++) {
			for (int k = 0; k < 101; k++) {
				if (arr[i][k]) v++;
			}
		}
		
		bw.write(v + "");
		bw.flush();

		br.close();
		bw.close();
	}
}
