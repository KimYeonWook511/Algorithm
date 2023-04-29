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
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[1003]; // idx 1 : l=0, idx 1001 : l=1000
		int max = 0;
		int leftIdx = 0;
		int rightIdx = 1002;
		int result = 0;
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			max = Math.max(max, h);
			
			arr[l] = h;
		}

		for (int i = 1; i <= 1001; i++) {
			if (arr[i] > arr[leftIdx]) {
				result += arr[leftIdx] * (i - leftIdx);
				leftIdx = i;
				
				if (arr[leftIdx] == max) break;
			}
		}
		
		for (int i = 1001; i > 0; i--) {
			if (arr[i] > arr[rightIdx]) {
				result += arr[rightIdx] * (rightIdx - i);
				rightIdx = i;
				
				if (arr[rightIdx] == max) break;
			}
		}
		
		result += (rightIdx - leftIdx + 1) * max; // 맨 위 천장
		
		bw.write(Integer.toString(result));
		
		br.close();
		bw.close();
	}
}