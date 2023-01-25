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
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int max1 = 0; // 제일 큰 수
		int max2 = 0; // 두 번째로 큰 수
		int max3 = 0; // 세 번째로 큰 수
		int arr[] = new int[n];
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			if (number < m - 1) {
				if (number > max1) {
					max3 = max2;
					max2 = max1;
					max1 = number;
					
				} else if (number > max2) {
					max3 = max2;
					max2 = number;
					
				} else if (number > max3) {
					max3 = number;
				}
				
				arr[i] = number;
			}
		}
		
		if (m > max1 + max2 + max3) { // 탐색을 시작하는 경우의 수를 줄이기 위한 작업
			result = max1 + max2 + max3;
			
		} else {
			result = blackJack(arr, m);
		}
		
		bw.write(Integer.toString(result));
		bw.flush();

		br.close();
		bw.close();
	}
	
	static int blackJack(int arr[], int num) {
		for (int idx1 = 0; idx1 < n - 2; idx1++) {
			for (int idx2 = idx1 + 1; idx2 < n - 1; idx2++) {
				for (int idx3 = idx2 + 1; idx3 < n; idx3++) {
					if (num == arr[idx1] + arr[idx2] + arr[idx3]) {
						return num;
					}
				}
			}
		}
		
		return blackJack(arr, num - 1);
	}
}