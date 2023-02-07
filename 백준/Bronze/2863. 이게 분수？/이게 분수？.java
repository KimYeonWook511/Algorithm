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
		double arr[][] = new double[2][2];
		double max = 0;
		int result = 0;
		
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int k = 0; k < 2; k++) {
				arr[i][k] = Double.parseDouble(st.nextToken());
			}
		}
		
		for (int spin = 0; spin < 4; spin++) {
			double value = arr[0][0] / arr[1][0] + arr[0][1] / arr[1][1];
			
			if (value > max) {
				max = value;
				result = spin;
			}
			
			// spin하기
			double temp = arr[1][1];
			arr[1][1] = arr[0][1];
			arr[0][1] = arr[0][0];
			arr[0][0] = arr[1][0];
			arr[1][0] = temp;
		}
		
		bw.write(Integer.toString(result));
		bw.flush();

		br.close();
		bw.close();
	}
}