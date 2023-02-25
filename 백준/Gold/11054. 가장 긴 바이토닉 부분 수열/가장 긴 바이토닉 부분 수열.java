import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[n];
		int dpLeft[] = new int[n];
		int dpRight[] = new int[n];
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dpLeft[i] = 1;
			dpRight[i] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			for (int k = 0; k < i; k++) {
				if (arr[k] < arr[i] && dpLeft[i] < dpLeft[k] + 1) {
					dpLeft[i] = dpLeft[k] + 1;
				}
				
				if (arr[n - 1 - k] < arr[n - 1 - i] && dpRight[n - 1 - i] < dpRight[n - 1 - k] + 1) {
					dpRight[n - 1 - i] = dpRight[n - 1 - k] + 1;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dpLeft[i] + dpRight[i]);
		}
		
		bw.write(Integer.toString(max - 1));
		bw.flush();

		br.close();
		bw.close();
	}
}