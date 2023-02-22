import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n + 3];
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		
		for (int i = 4; i < n + 3; i++) {
			if (i % 2 == 0) {
				if (i % 3 == 0) {
					// 2와 3 둘 다 나누어 떨어질 경우
					arr[i] = Math.min(Math.min(arr[i - 1], arr[i / 2]), Math.min(arr[i - 1], arr[i / 3])) + 1;
					
				} else {
					arr[i] = Math.min(arr[i - 1], arr[i / 2]) + 1;
				}
				
			} else if (i % 3 == 0) {
				arr[i] = Math.min(arr[i - 1], arr[i / 3]) + 1;
				
			} else {
				arr[i] = arr[i - 1] + 1;
			}
		}
		
		bw.write(Integer.toString(arr[n]));
		bw.flush();

		br.close();
		bw.close();
	}
	
}