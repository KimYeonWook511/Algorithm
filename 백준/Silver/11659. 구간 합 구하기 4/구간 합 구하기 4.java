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
		int arr[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken()); // n은 1 이상
		
		for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		for (int run = 0; run < m; run++) {
			st = new StringTokenizer(br.readLine());
			int startIdx = Integer.parseInt(st.nextToken()) - 1;
			int endIdx = Integer.parseInt(st.nextToken()) - 1;
			
			if (startIdx == 0) bw.write(arr[endIdx] + "\n");
			else bw.write(arr[endIdx] - arr[startIdx - 1] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}