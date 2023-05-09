import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int rope[] = new int[10001];
		int w = 0;
		int k = 0;
		
		for (int i = 0; i < n; i++) {
			rope[Integer.parseInt(br.readLine())]++;
		}
		
		for (int i = 10000; i > 0; i--) {
			k += rope[i];
			w = Math.max(w, k * i);
		}
		
		System.out.println(w);
		
		br.close();
	}
}