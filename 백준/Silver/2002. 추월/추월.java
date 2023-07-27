import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		int arr[] = new int[n];
		int cnt = 0;
		
		for (int run = 0; run < n; run++) {
			map.put(br.readLine(), run);
		}
		
		for (int run = 0; run < n; run++) {
			arr[run] = map.get(br.readLine());
		}
		
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > i) {
				cnt++;
				continue;
			}
			
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j]) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}
}