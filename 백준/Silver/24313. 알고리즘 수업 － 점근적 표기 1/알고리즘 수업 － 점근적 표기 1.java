import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine());
		int n0 = Integer.parseInt(br.readLine());
		
		if (a1 * n0 + a2 <= c * n0 && c >= a1) bw.write("1");
		else bw.write("0");
		
		bw.flush();

		br.close();
		bw.close();
	}
}