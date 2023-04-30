import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == 'P') {
				stack.push(c);
				
			} else if (i == str.length() - 1 || str.charAt(i + 1) == 'A' || stack.empty() || stack.size() < 2) {
				// 마지막이 P가 아닌 경우 || 다음 문자열이 A인 경우 || 스택이 빈 경우 || 스택에 P가 2개 미만인 경우
				stack.push('N');
				break;
				
			} else {
				stack.pop();
				i++;
			}
		}
		
		bw.write(stack.size() == 1 && stack.pop() == 'P' ? "PPAP" : "NP");
		
		br.close();
		bw.close();
	}
}