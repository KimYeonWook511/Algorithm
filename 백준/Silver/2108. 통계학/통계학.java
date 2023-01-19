import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[8001]; // -4000 ~ 4000
		
		for (int run = 0; run < n; run++) {
			int num = Integer.parseInt(br.readLine());
			
			arr[num + 4000]++;
		}
		
		int sum = 0; // 합
		int medianCnt = 0; // 중앙값 카운트
		int median = 0; // 중앙값
		int modeCnt = 0; // 최빈값 카운트
		int mode = 0; // 최빈값
		int min = 0; // 최솟값
		int max = 0; // 최댓값
		
		for (int i = 0; i < arr.length; i++) {
			for (int run = 1; run <= arr[i]; run++) {
				sum += i - 4000;
				medianCnt++;
				
				if (medianCnt == 1) min = i - 4000;
				if (medianCnt == n) max = i - 4000;
				if (medianCnt == n / 2 + 1) median = i - 4000;
				if (run == modeCnt && (i - 4000 > mode)) {
					mode = i - 4000 + 8000;
				}
				if (run > modeCnt) {
					modeCnt = run;
					mode = i - 4000;
				}
			}
		}
		
		bw.write(Math.round(sum * 1.0 / n)  + "\n");
		bw.write(median + "\n");
		bw.write((mode > 4000 ? mode - 8000 : mode) + "\n");
		bw.write((max - min) + "\n");
		bw.flush();

		br.close();
		bw.close();
	}
}
