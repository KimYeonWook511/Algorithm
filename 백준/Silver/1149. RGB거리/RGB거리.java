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
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int result[] = new int[3];
		int rgb[] = new int[3];
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 3; i++) {
				rgb[i] = Integer.parseInt(st.nextToken());
			}
			
			rgb[0] += Math.min(result[1], result[2]);
			rgb[1] += Math.min(result[0], result[2]);
			rgb[2] += Math.min(result[0], result[1]);
			result[0] = rgb[0];
			result[1] = rgb[1];
			result[2] = rgb[2];
		}
		
		bw.write(Integer.toString(Math.min(result[0], Math.min(result[1], result[2]))));
		bw.flush();

		br.close();
		bw.close();
	}
	
}