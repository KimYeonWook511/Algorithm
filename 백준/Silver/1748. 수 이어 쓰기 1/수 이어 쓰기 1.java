import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int i = 1;
		int result = 0;
		
		while (n >= Math.pow(10, i)) {
			result += i * 9 * Math.pow(10, i - 1);
			i++;
		}
		
		result += i * (n - Math.pow(10, i - 1) + 1); 
		
		System.out.println(result);

		br.close();
	}
}