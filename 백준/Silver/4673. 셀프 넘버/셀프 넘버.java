import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean selfNumbers[] = new boolean[10000];
		
		for (int n = 1; n < 10000; n++) {
			int dn = d(n);
			
			if (dn <= 10000) selfNumbers[dn - 1] = true;
		}
		
		for (int i = 0; i < selfNumbers.length; i++) {
			if (!selfNumbers[i]) bw.write((i + 1) + "\n");
		}
		
		bw.flush();

		bw.close();
		
	}
	
	static int d(int n) {
		String strN = Integer.toString(n);
		int result = 0;
		
		for (int i = 0; i < strN.length(); i++) {
			result += Integer.parseInt(Character.toString(strN.charAt(i)));
		}
		
		return n + result;
	}
}
