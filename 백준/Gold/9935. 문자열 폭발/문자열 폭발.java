import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		String str = br.readLine();
		String boom = br.readLine();
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		
		for (int idx = 0; idx < str.length(); idx++) {
			char c = str.charAt(idx);
			
			if (cnt == boom.length()) {
				while (cnt > 0) {
					stack.pop();
					cnt--;
				}
				
				if (!stack.empty()) cnt = stack.peek() + 1;
			}
			
			if (c == boom.charAt(0)) { // 폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다
				stack.push(0);
				cnt = 1;
				
			} else if (c == boom.charAt(cnt)) {
				stack.push(cnt++);
				
			} else {
				int result[] = new int[stack.size()];
				
				for (int i = result.length - 1; i >= 0; i--) {
					result[i] = stack.pop();
				}
				
				for (int i = 0; i < result.length; i++) {
					sb.append(boom.charAt(result[i]));
				}
				
				sb.append(c);
				cnt = 0;
			}
		}
		
		if (cnt == boom.length()) {
			while (cnt > 0) {
				stack.pop();
				cnt--;
			}
		}
		
		int result[] = new int[stack.size()];
		
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		
		for (int i = 0; i < result.length; i++) {
			sb.append(boom.charAt(result[i]));
		}
		
		bw.write(sb.toString().equals("") ? "FRULA" : sb.toString()); 
		
		br.close();
		bw.close();
	}
}