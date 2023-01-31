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
	static int n;
	static int min = 1_000_000, max = 2;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num < min) min = num;
			if (num > max) max = num;
		}
		
		bw.write(Integer.toString(min * max));
		bw.flush();

		br.close();
		bw.close();
	}
}