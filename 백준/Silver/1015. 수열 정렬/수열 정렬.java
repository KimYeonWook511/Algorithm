import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a[][] = new int[n][2];
		int p[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i][0] = i;
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		for (int i = 0; i < n; i++) {
			p[a[i][0]] = i;
		}
		
		for (int i = 0; i < n; i++) {
			bw.write(p[i] + " ");
		}
		
		br.close();
		bw.close();
	}
}
