import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, arr[], stack[], result[], idx;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N + 1];
		stack = new int[N + 1];
		result = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		stack[N] = N;
		idx = N;
		
		for (int i = N - 1; i >= 1; i--) {
			while (idx <= N && arr[i] > arr[stack[idx]]) {
				result[stack[idx++]] = i;
			}
			
			stack[--idx] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}