import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int x = 1; x <= n; x++) {
			if(seq(x)) cnt++;
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();

		br.close();
		bw.close();
	}

	static boolean seq(int x) {
		if (x < 100) return true;
		
		String strX = Integer.toString(x);
		int arr[] = new int[strX.length()];

		for (int i = 0; i < strX.length(); i++) {
			arr[i] = Integer.parseInt(Character.toString(strX.charAt(i)));
		}
		
		int d = arr[1] - arr[0];
		
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] != arr[i - 1] + d) return false;
		}
		
		return true;
	}
}
