import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String str = br.readLine();
			
			if (str.equals("*")) break;
			
			int len = str.length();
			boolean flag = false;
			
			for (int d = 1; d < len - 1; d++) {
				Set<String> set = new HashSet<String>();
				
				for (int i = 0; i + d < len; i++) {
					if (!set.add(Character.toString(str.charAt(i)) + Character.toString(str.charAt(i + d)))) flag = true;
				}
				
				if (flag) break;
			}
			
			bw.write(flag ? str + " is NOT surprising.\n" : str + " is surprising.\n");
		}
		
		br.close();
		bw.close();
	}
}