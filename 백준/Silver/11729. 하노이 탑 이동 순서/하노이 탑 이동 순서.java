import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		
		move(1, 3, 2, n);
		bw.write(cnt + "\n");
		bw.write(sb.toString());
		
		bw.flush();

		br.close();
		bw.close();
	}
	
	static void move(int from, int to, int middle, int num) {
		cnt++;
		
		if (num == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}
			
		move(from, middle, to, num - 1);
		sb.append(from + " " + to + "\n");
		move(middle, to, from, num - 1);
	}
}
