import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(Long.parseLong(br.readLine()) % 2 == 0 ? "CY" : "SK");
		
		br.close();
	}
}