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
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a[] = new int[n + 1];
		int b[] = new int[m + 1];
		a[n] = 1_000_000_001;
		b[m] = 1_000_000_001;
		int aIdx = 0;
		int bIdx = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		while (aIdx < n || bIdx < m) {
			if (a[aIdx] <= b[bIdx]) bw.write(a[aIdx++] + " ");
			else bw.write(b[bIdx++] + " ");
		}
		
		br.close();
		bw.close();
	}
}