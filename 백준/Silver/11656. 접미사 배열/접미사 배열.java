import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		TreeSet<String> set = new TreeSet<>();
		
		for (int i = 0; i < str.length(); i++) {
			set.add(str.substring(i, str.length()));
		}
		
		while (!set.isEmpty()) {
			bw.write(set.pollFirst() + "\n");
		}
		
		br.close();
		bw.close();
	}
}