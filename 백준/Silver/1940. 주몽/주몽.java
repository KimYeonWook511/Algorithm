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
		
		br.readLine(); // n
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean arr[] = new boolean[10_000_001];
		int startIdx = 1;
		int endIdx = m - 1;
		int cnt = 0;
		
		while (st.hasMoreTokens()) {
			arr[Integer.parseInt(st.nextToken())] = true;
		}
		
		while (startIdx < endIdx) {
			if (arr[startIdx] && arr[endIdx]) cnt++;
			
			startIdx++;
			endIdx--;
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();

		br.close();
		bw.close();
	}
}