import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n + 1][3];
		int rank = 1;
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			int country = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[country][0] = g;
			arr[country][1] = s;
			arr[country][2] = b;
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i][0] > arr[k][0]) rank++;
			else if (arr[i][0] == arr[k][0] && arr[i][1] > arr[k][1]) rank++;
			else if (arr[i][0] == arr[k][0] && arr[i][1] == arr[k][1] && arr[i][2] > arr[k][2]) rank++;
		}
		
		System.out.println(rank);
		
		br.close();
	}
}
