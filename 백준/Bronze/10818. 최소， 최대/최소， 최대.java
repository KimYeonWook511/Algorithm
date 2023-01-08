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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int min = Integer.parseInt(st.nextToken());
		int max = min;

		while (st.hasMoreTokens()) {
			int v = Integer.parseInt(st.nextToken());

			if (v < min) {
				min = v;

			} else if (v > max) {
				max = v;

			}
		}

		bw.write(min + " " + max);
		bw.flush();

		br.close();
		bw.close();
	}
}
