import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int MAX = 1_000_000_001;
	
	public static void main(String[] args) throws IOException {

		ArrayList<String> cmdList = new ArrayList<>();
		
		while (true) {
			String cmd = br.readLine();
			
			if (cmd.equals("QUIT"))
				break;

			if (cmd.equals("END")) {
				int n = Integer.parseInt(br.readLine());
				Stack<Integer> stack[] = new Stack[n];

				for (int i = 0; i < n; i++) {
					stack[i] = new Stack<>();
					stack[i].push(Integer.parseInt(br.readLine()));
				}
				
				while (!cmdList.isEmpty()) {
					st = new StringTokenizer(cmdList.remove(0));
					cmd = st.nextToken();
					int num = 0;
					
					if (st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());
					
					for (int i = 0; i < n; i++) {
						int temp = 0;

						if (!stack[i].empty() && stack[i].peek() == MAX) {
							// 이미 에러난 경우
							continue;
						}
						
						if (cmd.equals("NUM")) {
							stack[i].push(num);
							
						} else if (stack[i].empty()) {
							// 스택이 비었을 때 연산은 모두 에러
							stack[i].push(MAX);
							
						} else if (cmd.equals("POP")) {
							stack[i].pop();
							
						} else if (cmd.equals("INV")) {
							stack[i].push(stack[i].pop() * -1);
							
						} else if (cmd.equals("DUP")) {
							stack[i].push(stack[i].peek());
							
						} else if (stack[i].size() < 2) {
							stack[i].push(MAX);
							
						} else if (cmd.equals("SWP")) {
							temp = stack[i].pop();
							int temp2 = stack[i].pop();
							stack[i].push(temp);
							stack[i].push(temp2);
							
						} else if (cmd.equals("ADD")) {
							temp = stack[i].pop() + stack[i].pop();
							
							if (Math.abs(temp) >= MAX) stack[i].push(MAX);
							else stack[i].push(temp);
							
						} else if (cmd.equals("SUB")) {
							temp = stack[i].pop();
							temp = stack[i].pop() - temp;
							
							if (Math.abs(temp) >= MAX) stack[i].push(MAX);
							else stack[i].push(temp);
							
						} else if (cmd.equals("MUL")) {
							long temp2 = (long)stack[i].pop() * (long)stack[i].pop();
							
							if (Math.abs(temp2) >= MAX) stack[i].push(MAX);
							else stack[i].push((int)temp2);
							
						} else if (cmd.equals("DIV")) {
							temp = stack[i].pop();

							if (temp == 0) stack[i].push(MAX);
							else stack[i].push(stack[i].pop() / temp);

						} else if (cmd.equals("MOD")) {
							temp = stack[i].pop();

							if (temp == 0) stack[i].push(MAX);
							else stack[i].push(stack[i].pop() % temp);

						}
					}
				}
				
				for (int i = 0; i < n; i++) {
					bw.write(stack[i].empty() || stack[i].peek() == MAX || stack[i].size() > 1 ? "ERROR\n" : stack[i].pop() + "\n");
				}
				bw.write("\n");
				br.readLine();
				
			} else {
				cmdList.add(cmd);
			}
		}

		br.close();
		bw.close();
	}
}