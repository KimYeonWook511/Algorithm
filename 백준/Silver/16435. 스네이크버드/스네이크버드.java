import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int arr[] = new int[10001];
		
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < n; run++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		
		for (int i = 1; i <= l; i++) {
			if (i > 10000) break;
			
			if (arr[i] > 0) {
				arr[i]--;
				l++;
				i--;
			}
		}
		
		System.out.println(l);
		
		br.close();
	}
}