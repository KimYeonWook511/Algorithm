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
		int m = Integer.parseInt(st.nextToken());
		int arr[] = new int[n + 1];
		
		for (int run = 0; run < m; run++) {
			st = new StringTokenizer(br.readLine());
			int startIdx = Integer.parseInt(st.nextToken());
			int endIdx = Integer.parseInt(st.nextToken());
			int no = Integer.parseInt(st.nextToken());
			
			for (int i = startIdx; i <= endIdx; i++) {
				arr[i] = no;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			bw.write(arr[i] + " ");
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
