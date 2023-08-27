import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][2];
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			arr[run][0] = Integer.parseInt(st.nextToken());
			arr[run][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int minute = 0;
		
		for (int i = 0; i < n; i++) {
			minute = Math.max(minute, arr[i][0]);
			
			minute += arr[i][1];
		}
		
		System.out.println(minute);
		
		br.close();
	}
}
