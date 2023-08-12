import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int l = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine()); 
		int left = 0;
		int right = 1000;
		
		for (int i = 0; i < l; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num > n) right = Math.min(right, num);
			else left = Math.max(left, num);
		}
		
		System.out.println(left == n ? "0" : (right - n) * (n - left) - 1);
		
		br.close();
	}
}