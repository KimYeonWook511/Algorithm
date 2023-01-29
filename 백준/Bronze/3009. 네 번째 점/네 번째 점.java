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
	static boolean xArr[] = new boolean[1000];
	static boolean yArr[] = new boolean[1000];
	static int x, y;
	
	public static void main(String[] args) throws IOException {
		for (int run = 0; run < 3; run++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			xArr[x - 1] = !xArr[x - 1];
			yArr[y - 1] = !yArr[y - 1];
		}
		
		for (int i = 0; i < 1000; i++) {
			if (xArr[i]) x = i + 1;
			if (yArr[i]) y = i + 1;
		}
		
		bw.write(x + " " + y);
		bw.flush();

		br.close();
		bw.close();
	}
}