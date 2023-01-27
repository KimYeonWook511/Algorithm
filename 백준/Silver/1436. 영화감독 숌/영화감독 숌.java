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
		int num = 665;
		
		while (n > 0) {
			num++;
			if (Integer.toString(num).contains("666")) n--;
		}
		
		bw.write(Integer.toString(num));
		bw.flush();

		br.close();
		bw.close();
	}
}