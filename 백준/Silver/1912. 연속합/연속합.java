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
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[n];
		arr[0] = Integer.parseInt(st.nextToken());
		int max = arr[0];
		
		for (int i = 1; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			arr[i] = arr[i - 1] + num > num ? arr[i - 1] + num : num; // 현재의 수가 앞서 더한 수보다 클 시 다시 자기 자신부터 합 시작
			
			max = arr[i] > max ? arr[i] : max;
		}
		
		bw.write(Integer.toString(max));
		bw.flush();

		br.close();
		bw.close();
	}
}