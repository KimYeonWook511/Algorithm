import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		boolean arr[] = new boolean[2001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < n; run++) {
			arr[Integer.parseInt(st.nextToken()) + 1000] = true;
		}

		for (int i = 0; i < 2001; i++) {
			if (arr[i]) bw.write(i - 1000 + " ");
		}
		
		br.close();
		bw.close();
	}
}