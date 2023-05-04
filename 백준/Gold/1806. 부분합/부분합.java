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
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int arr[] = new int[n + 1];
		int sum = 0;
		int len = 100_000;
		int endIdx = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int startIdx = 0; startIdx < n; startIdx++) {
			while (endIdx <= n) {
				if (sum >= s) {
					sum -= arr[startIdx];
					len = Math.min(len, endIdx - startIdx);
					break;
				}
				
				sum += arr[endIdx++];
			}
		}
		
		bw.write(Integer.toString(len == 100_000 ? 0 : len));
		
		br.close();
		bw.close();
	}
}