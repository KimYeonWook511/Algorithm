import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int r = 0; r < t; r++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			int arr[][] = new int[k + 1][n];
			
			for (int idxK = 0; idxK < arr.length; idxK++) {
				arr[idxK][0] = 1;
			}
			
			for (int idxN = 0; idxN < n; idxN++) {
				arr[0][idxN] = 1;
			}
			
			for (int idxK = 1; idxK < arr.length; idxK++) {
				for (int idxN = 1; idxN < n; idxN++) {
					arr[idxK][idxN] = arr[idxK - 1][idxN] + arr[idxK][idxN - 1];
				}
			}
			
			for (int idxN = 0; idxN < n; idxN++) {
				cnt += arr[k][idxN];
			}
			
			bw.write(cnt + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}