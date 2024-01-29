import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, len;
	static char arr[], result[];
	static boolean chk[];
	static String line;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < N; run++) {
			line = br.readLine();
			len = line.length();
			
			arr = new char[len];
			result = new char[len];
			chk = new boolean[len];
			
			for (int i = 0; i < len; i++) {
				arr[i] = line.charAt(i);
			}
			
			Arrays.sort(arr);
			
			func(0);
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static void func(int cnt) {
		if (cnt == len) {
			for (int i = 0; i < cnt; i++) {
				sb.append(result[i]);
			}
			
			sb.append("\n");
			
			return;
		}
		
		char pre = ' ';
		
		for (int i = 0; i < len; i++) {
			if (chk[i]) continue;
			if (arr[i] == pre) continue;
			
			chk[i] = true;
			result[cnt] = arr[i];
			func(cnt + 1);
			chk[i] = false;
			
			pre = arr[i];
		}
	}
}