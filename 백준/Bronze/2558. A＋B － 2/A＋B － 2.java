import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int sum;
	
	public static void main(String[] args) throws IOException {
		sum = Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine());
		
		bw.write(Integer.toString(sum));
		bw.flush();

		br.close();
		bw.close();
	}
}