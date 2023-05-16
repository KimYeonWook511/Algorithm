import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String str[] = br.readLine().split("-");
		int operand[] = new int[str.length];
		int result = 0;
		
		for (int i = 0; i < str.length; i++) {
			int num = 0;
			
			for (int idx = 0; idx < str[i].length(); idx++) {
				char c = str[i].charAt(idx);
				
				if (c == '+') {
					operand[i] += num;
					num = 0;
					
				} else {
					num = num * 10 + c - '0';
				}
			}
			
			operand[i] += num;
		}
		
		result = operand[0];
		
		for (int i = 1; i < operand.length; i++) {
			result -= operand[i];
		}
		
		System.out.println(result);
		
		br.close();
	}
}