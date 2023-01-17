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
			
			int arr[] = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = i + 1;
			}
			
			for (int lv = 1; lv <= k; lv++) {
				for (int i = 1; i < n; i++) {
					arr[i] += arr[i - 1];
				}
			}
			
			bw.write(arr[n - 1] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}