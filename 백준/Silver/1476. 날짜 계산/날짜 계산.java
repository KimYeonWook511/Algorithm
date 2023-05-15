import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int y = 1;
		
		if (e == 15) e = 0;
		if (s == 28) s = 0;
		if (m == 19) m = 0;
		
		while (true) {
			if (y % 15 == e && y % 28 == s && y % 19 == m) break;
			
			y++;
		}
		
		System.out.println(y);
		
		br.close();
	}
}