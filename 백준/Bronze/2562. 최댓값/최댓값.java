import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = 0;
		int idx = 0;
		
		for (int i = 0; i < 9; i++) {
			int v = Integer.parseInt(br.readLine());
			
			if (v > max) { 
				max = v;
				idx = i + 1;
			}
		}
		
		bw.write(Integer.toString(max) + "\n");
		bw.write(Integer.toString(idx));
		bw.flush();

		br.close();
		bw.close();
	}
}
