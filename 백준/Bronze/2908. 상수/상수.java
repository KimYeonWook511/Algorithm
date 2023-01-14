import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int output = 0;
	
		while (st.hasMoreTokens()) {
			String number = st.nextToken();
			number = Character.toString(number.charAt(2)) 
					+ Character.toString(number.charAt(1)) 
					+ Character.toString(number.charAt(0));
			
			if (Integer.parseInt(number) > output) output = Integer.parseInt(number);
		}
		
		bw.write(Integer.toString(output));
		bw.flush();

		br.close();
		bw.close();
	}
}