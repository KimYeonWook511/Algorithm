import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		while (true) {
			String str = br.readLine();
			
			if (str.equals("0")) break;
			
			boolean flag = true;
			
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) flag = false;
			}
			
			bw.write(flag ? "yes\n" : "no\n");
		}
		
		br.close();
		bw.close();
	}
}