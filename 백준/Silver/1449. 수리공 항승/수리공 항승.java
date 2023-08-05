import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		boolean arr[] = new boolean[1001];
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < n; run++) {
			arr[Integer.parseInt(st.nextToken())] = true;
		}

		for (int i = 1; i <= 1000; i++) {
			if (arr[i]) {
				cnt++;
				i += l - 1;
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}
}
