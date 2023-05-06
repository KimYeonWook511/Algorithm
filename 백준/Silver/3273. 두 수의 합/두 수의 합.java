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
		int x = Integer.parseInt(br.readLine()) - 1;
		boolean arr[] = new boolean[2_000_001];
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(st.nextToken())] = true;
		}
		
		for (int startIdx = 1; startIdx < x; startIdx++, x--) {
			if (arr[startIdx] && arr[x]) cnt++;
		}
		
		bw.write(Integer.toString(cnt));
		
		br.close();
		bw.close();
	}
}