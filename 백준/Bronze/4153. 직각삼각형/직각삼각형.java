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
	static int a, b, c;
	static int x, y, z; // x : 밑변 , y : 높이 , z : 빗변
	
	public static void main(String[] args) throws IOException {
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			z = Math.max(a, Math.max(b, c));
			x = Math.min(a, Math.min(b, c));
			
			if (z == a && x == b || z == b && x == a) y = c;
			else if (z == a && x == c || z == c && x == a) y = b;
			else y = a;
			
			if (a == 0) break;
			else if (Math.pow(z, 2) == Math.pow(x, 2) + Math.pow(y, 2)) bw.write("right\n");
			else bw.write("wrong\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}