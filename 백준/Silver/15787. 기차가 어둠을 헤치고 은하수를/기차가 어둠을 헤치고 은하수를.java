import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, arr[], cnt, temp = -1, i;
	static String cmd;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());

			cmd = st.nextToken();
			i = Integer.parseInt(st.nextToken());

			if (cmd.equals("1")) {
				arr[i - 1] |= (1 << Integer.parseInt(st.nextToken()));

			} else if (cmd.equals("2")) {
				arr[i - 1] &= ~(1 << Integer.parseInt(st.nextToken()));

			} else if (cmd.equals("3")) {
				arr[i - 1] <<= 1;
				arr[i - 1] &= ~(1 << 21);

			} else {
				arr[i - 1] >>= 1;
				arr[i - 1] &= ~1;
			}
		}

		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			if (arr[i] == temp) continue;

			cnt++;
			temp = arr[i];
		}

		System.out.println(cnt);

		br.close();
	}
}