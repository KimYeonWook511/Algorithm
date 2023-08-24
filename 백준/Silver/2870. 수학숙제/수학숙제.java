import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<BigInteger> list = new ArrayList<BigInteger>(); 
		
		for (int run = 0; run < n; run++) {
			String str = br.readLine();
			int len = str.length();
			
			String num = ""; 
			
			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				
				if ('0' <= c && c <= '9') {
					num += c;
					
				} else if (num != "") {
					list.add(new BigInteger(num));
					num = "";
				}
			}
			
			if (num != "") list.add(new BigInteger(num));
		}

		Collections.sort(list);
		int size = list.size();
		
		for (int i = 0; i < size; i++) {
			bw.write(list.get(i) + "\n");
		}
		
		br.close();
		bw.close();
	}
}