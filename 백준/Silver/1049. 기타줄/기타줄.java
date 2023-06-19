import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int min[] = new int[2];
		
		min[0] = min[1] = 1000;
		
		for (int r = 0; r < m; r++) {
			st = new StringTokenizer(br.readLine());
			min[0] = Math.min(min[0], Integer.parseInt(st.nextToken()));
			min[1] = Math.min(min[1], Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(Math.min(Math.min((n / 6 + 1) * min[0] , n * min[1]), n / 6 * min[0] + n % 6 * min[1]));
		
		br.close();
	}
}