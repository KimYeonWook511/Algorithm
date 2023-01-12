import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arrGrade[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			arrGrade[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		for (int i = 0; i < arrGrade.length; i++) {
			if (arrGrade[i] > max) max = arrGrade[i];
		}
		
		double total = 0;
		
		for (int i = 0; i < arrGrade.length; i++) {
			total += arrGrade[i] * 100.0 / max;
		}
		
		bw.write(Double.toString(total / n));
		bw.flush();

		br.close();
		bw.close();
	}
}
