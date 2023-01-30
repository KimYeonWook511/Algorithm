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
	static int k;
	static int nextDirection;
	static int largeS, smallS;
	static int arr[] = new int[6];
	static int idx;
	
	public static void main(String[] args) throws IOException {
		k = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < 6; run++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			
			arr[run] = width;
			
			if (direction != nextDirection && run != 0) idx = run;
			
			next(direction);
		}
		
		bw.write(Integer.toString(cal()));
		bw.flush();

		br.close();
		bw.close();
	}
	
	static void next(int direction) {
		switch (direction) {
			case 1:
				nextDirection = 4;
				break;
			case 2:
				nextDirection = 3;
				break;
			case 3:
				nextDirection = 1;
				break;
			default:
				nextDirection = 2;
		}
	}
	
	static int cal() {
		switch (idx) {
			case 1:
				largeS = arr[3] * arr[4];
				smallS = arr[idx] * arr[idx - 1];
				break;
			case 2:
				largeS = arr[4] * arr[5];
				smallS = arr[idx] * arr[idx - 1];
				break;
			case 3:
				largeS = arr[5] * arr[0];
				smallS = arr[idx] * arr[idx - 1];
				break;
			case 4:
				largeS = arr[0] * arr[1];
				smallS = arr[idx] * arr[idx - 1];
				break;
			case 5:
				largeS = arr[1] * arr[2];
				smallS = arr[idx] * arr[idx - 1];
				break;
			default:
				largeS = arr[2] * arr[3];
				smallS = arr[0] * arr[5];
		}
		
		return k * (largeS - smallS);
	}
}