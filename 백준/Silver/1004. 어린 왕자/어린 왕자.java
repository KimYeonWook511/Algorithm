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
	static int t, r;
	static int x1, y1, x2, y2;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			r = Integer.parseInt(br.readLine());
			
			while (r > 0) {
				st = new StringTokenizer(br.readLine());
				
				cal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
				r--;
			}
			
			bw.write(Integer.toString(cnt) + "\n");
			cnt = 0;
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
	
	static void cal(int cx, int cy, int cr) {
		boolean departure = Math.pow((x1 - cx), 2) + Math.pow((y1 - cy), 2) < Math.pow(cr, 2);
		boolean arrival = Math.pow((x2 - cx), 2) + Math.pow((y2 - cy), 2) < Math.pow(cr, 2);
		
		if (departure && arrival) return;
		else if (departure) cnt++;
		else if (arrival) cnt++;
	}
}