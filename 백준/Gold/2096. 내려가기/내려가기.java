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
		int dpMin[] = new int[3];
		int dpMax[] = new int[3];
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			dpMin[0] = Math.min(dpMin[0], dpMin[1]);
			dpMin[2] = Math.min(dpMin[1], dpMin[2]);
			dpMin[1] = Math.min(dpMin[0], dpMin[2]);
			dpMax[0] = Math.max(dpMax[0], dpMax[1]);
			dpMax[2] = Math.max(dpMax[1], dpMax[2]);
			dpMax[1] = Math.max(dpMax[0], dpMax[2]);
			
			dpMin[0] += l;
			dpMax[0] += l;
			dpMin[1] += m;
			dpMax[1] += m;
			dpMin[2] += r;
			dpMax[2] += r;
		}
		
		bw.write(Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2])) + " " + Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2])));
		bw.flush();

		br.close();
		bw.close();
	}
}