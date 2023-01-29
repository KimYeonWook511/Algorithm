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
	static int x, y, w, h;
	static int a, b;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		a = x - 0 < w - x ? x - 0 : w - x;
		b = y - 0 < h - y ? y - 0 : h - y;
		
		bw.write(a < b ? Integer.toString(a): Integer.toString(b));
		bw.flush();

		br.close();
		bw.close();
	}
}