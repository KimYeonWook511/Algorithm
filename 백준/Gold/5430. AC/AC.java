import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			String cmd = br.readLine();
			Integer.parseInt(br.readLine()); // n
			String arrStr = br.readLine();
			arrStr = arrStr.substring(1, arrStr.length() - 1);
			String arr[] = arrStr.split(",");
			
			Deque<String> deque = new ArrayDeque<String>();
			boolean rev = false;
			boolean flag = true;
			
			if (!arr[0].equals("")) {
				for (int i = 0; i < arr.length; i++) {
					deque.offerLast(arr[i]);
				}
			}
			
			for (int i = 0; i < cmd.length(); i++) {
				char c = cmd.charAt(i);
				
				if (c == 'R') {
					rev = !rev;
					
				} else if (rev) {
					if (deque.isEmpty()) {
						flag = false;
						break;
					}
					
					deque.pollLast();
					
				} else {
					if (deque.isEmpty()) {
						flag = false;
						break;
					}
					
					deque.pollFirst();
				}
			}
			
			if (flag) {
				bw.write("[");
				
				while (deque.size() > 1) {
					bw.write(rev ? deque.pollLast() + "," : deque.pollFirst() + ",");
				}
				
				bw.write(deque.size() == 0 ? "]\n" : deque.poll() + "]\n");
			} else {
				bw.write("error\n");
			}
		}

		br.close();
		bw.close();
	}
}