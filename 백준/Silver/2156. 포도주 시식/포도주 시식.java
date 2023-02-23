import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n + 2];
		int result[] = new int[n + 2];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		result[1] = arr[1];
		result[2] = arr[1] + arr[2];
		
		for (int i = 3; i <= n; i++) {
			result[i] = Math.max(Math.max(result[i - 2], result[i - 3] + arr[i - 1]) + arr[i], result[i - 1]);
		}
		
		bw.write(Integer.toString(result[n]));
		bw.flush();

		br.close();
		bw.close();
	}
}