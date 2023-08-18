import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int r = (int)Math.round(n * 0.15);
		double lv = 0;
		
		for (int run = 0; run < n; run++) {
			arr[run] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		
		for (int i = r; i < n - r; i++ ) {
			lv += arr[i];
		}
		
		System.out.println(Math.round(lv / (n - 2 * r)));
		
		br.close();
	}
}