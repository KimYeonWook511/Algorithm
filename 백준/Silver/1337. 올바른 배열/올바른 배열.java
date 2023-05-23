import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n + 4];
		int min = 5;
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = n; i < n + 4; i++) {
			arr[i] = 1_000_000_005;
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			
			for (int k = 1; k < 5; k++) {
				int cal = arr[i + k] - arr[i];
				
				if (cal > 4) break;
				
				cnt++;
				
				if (cal == 4) break;
			}
			
			min = Math.min(min, 4 - cnt);
		}
		
		System.out.println(min);
		
		br.close();
	}
}