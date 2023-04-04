import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int a = 1;
		int b = 1;
		
		for (int day = 4; day <= d; day++) {
			int sum = a + b;
			
			a = b;
			b = sum;
		}
		
		int ai = 1;
		
		while (true) {
			if ((k - a * ai) % b == 0) {
				bw.write(ai + "\n");
				bw.write((k - a * ai) / b + "");
				break;
			}
			
			ai++;
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}