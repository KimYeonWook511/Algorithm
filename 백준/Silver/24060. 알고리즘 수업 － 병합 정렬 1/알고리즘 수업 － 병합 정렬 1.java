import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[] tmp;
	static int k;
	static int cnt = 0;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		tmp = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(arr, 0, n - 1);
		bw.write(Integer.toString(result));
		bw.flush();

		br.close();
		bw.close();
	}
	
	static void merge_sort(int[] arr, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			
			merge_sort(arr, p, q);
			merge_sort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}
	
	static void merge(int[] arr, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j])
				tmp[t++] = arr[i++];
			else
				tmp[t++] = arr[j++];
				
		}
		
		while (i <= q)
			tmp[t++] = arr[i++];
		while (j <= r)
			tmp[t++] = arr[j++];
		
		i = p;
		t = 0;
		
		while (i <= r) {
			cnt++;
			
			if (cnt == k) {
				result = tmp[t];
				break;
			}
			
			arr[i++] = tmp[t++];
		}
	}
}