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
	static int t;
	static int x1, y1, r1, x2, y2, r2;
	
	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			double d = Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));
			
			bw.write(cal(d) + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
	
	static int cal(double d) {
		if (x1 == x2 && y1 == y2 && r1 == r2) return -1; // 같은 원
		else if (d == 0) return 0; // 동심원
		else if (d > r1 + r2) return 0; // 만나지 않음(외부에 있음)
		else if (d < Math.abs(r1 - r2)) return 0; // 만나지 않음(내부에 있음)
		else if (d == r1 + r2) return 1; // 외접
		else if (d == Math.abs(r1 - r2)) return 1; // 내접
		else return 2; // 두 점에서 만난다 (d > Math.abs(r1 - r2) && d < r1 + r2)
	}
}