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
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			if (left < right) {
				if (right % left == 0) bw.write("factor\n");
				else bw.write("neither\n");
				
			} else if (left > right) {
				if (left % right == 0) bw.write("multiple\n");
				else bw.write("neither\n");
				
			} else {
				break;
			}
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}