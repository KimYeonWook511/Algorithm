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
		int arr[] = new int[n + 1];
		int max = 0;
		int cnt = 1;
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		max = arr[n];
		
		for (int i = n - 1; i > 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				cnt++;
			}
		}
		
		bw.write(Integer.toString(cnt));
		
		br.close();
		bw.close();
	}
}
