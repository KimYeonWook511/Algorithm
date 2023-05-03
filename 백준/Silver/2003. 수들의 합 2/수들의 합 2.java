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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[] = new int[n + 1];
		int endIdx = 0;
		int cnt = 0;
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int startIdx = 0; startIdx < n; startIdx++) {
			while (endIdx <= n) {
				if (sum == m) {
					cnt++;
					sum -= arr[startIdx];
					break;
					
				} else if (sum > m) {
					sum -= arr[startIdx];
					break;
					
				} else {
					sum += arr[endIdx++];
				}
			}
		}
		
		bw.write(Integer.toString(cnt));
		
		br.close();
		bw.close();
	}
}