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
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		arr[0][0] = Integer.parseInt(br.readLine());
		int max = arr[0][0];
		
		for (int l = 1; l < n; l++) { // l : line
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i <= l; i++) {
				if (i == 0) {
					arr[l][i] = arr[l - 1][i] + Integer.parseInt(st.nextToken());
					
				} else {
					arr[l][i] = Math.max(arr[l - 1][i], arr[l - 1][i - 1]) + Integer.parseInt(st.nextToken());
					
				}
				
				if (arr[l][i] > max) max = arr[l][i];
			}
		}
		
		bw.write(Integer.toString(max));
		bw.flush();

		br.close();
		bw.close();
	}
	
}