import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int k = Integer.parseInt(br.readLine());
		int arr[] = new int[k];
		int sum = 0;
		int idx = 0;
		
		for (int run = 0; run < k; run++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) sum -= arr[--idx];
			else sum += arr[idx++] = num;
		}
		
		bw.write(Integer.toString(sum)); // 최종적으로 적어낸 수의 합이 (2^31 - 1) 이하
		
		br.close();
		bw.close();
	}
}