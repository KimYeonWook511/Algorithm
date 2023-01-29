import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s;
	static int sLen;
	static HashSet<String> set = new HashSet<>(); 
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		s = br.readLine();
		sLen = s.length();
		
		for (int len = 1; len <= sLen; len++) {
			for (int beginIdx = 0; beginIdx <= sLen - len; beginIdx++) {
				set.add(s.substring(beginIdx, beginIdx + len));
			}
		}
		
		bw.write(Integer.toString(set.size()));
		bw.flush();

		br.close();
		bw.close();
	}
}