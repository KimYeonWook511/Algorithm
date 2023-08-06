import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		
		for (int run = 1; run <= k; run++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int gap = 0;
			
			for (int i = 1; i < n; i++) {
				gap = Math.max(gap, arr[i] - arr[i - 1]);
			}
			
			bw.write("Class " + run + "\n");
			bw.write("Max " + arr[n - 1] + ", Min " + arr[0] + ", Largest gap " + gap + "\n");
		}
		
		br.close();
		bw.close();
	}
}
