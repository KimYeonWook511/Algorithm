import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for (int num = 0; num < n; num++) {
			if (search(num)) {
				result = num;
				break;
			}
		}
		
		bw.write(Integer.toString(result));
		bw.flush();

		br.close();
		bw.close();
	}
	
	static boolean search(int num) {
		String strNum = Integer.toString(num);
		
		for (int i = 0; i < strNum.length(); i++) {
			num += Integer.parseInt(Character.toString(strNum.charAt(i)));
		}
		
		if (num == n) return true;
		
		return false;
	}
}