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
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[n][m];
		
		for (int run = 0; run < 2; run++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < m; k++) {
					arr[i][k] += Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < m; k++) {
				bw.write(arr[i][k] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
