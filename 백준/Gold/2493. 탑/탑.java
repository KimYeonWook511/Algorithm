import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n + 1];
		int result[] = new int[n + 1];
		int stack[] = new int[n + 1];
		int top = n + 1;
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = n; i > 0; i--) {
			while (top != n + 1 && arr[i] > arr[stack[top]]) {
				result[stack[top]] = i;
				top++;
			}
			
			top--;
			stack[top] = i;
		}
		
		for (int i = 1; i <= n; i++) {
			bw.write(result[i] + " ");
		}
		
		br.close();
		bw.close();
	}
}