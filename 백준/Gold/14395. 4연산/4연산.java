import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		long s; // 1_000_000_000^2
		int idx; // 0: * | 1: + | 2: /
		Node pre;
		
		Node (long s, int idx, Node pre) {
			this.s = s;
			this.idx = idx;
			this.pre = pre;
		}
	}
	static char operator[] = {'*', '+', '/'};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long s = Long.parseLong(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		String result = null;
		
		if (s == t) result = "0";
		else if (t == 0) result = "-";

		if (result == null) {
			Set<Long> visited = new HashSet<>();
			Deque<Node> deque = new ArrayDeque<>();
			Node head = new Node(s, 0, null);
			deque.offer(head);
			visited.add(s);
			
			// 맨 처음에만 '/' 연산 함
			for (int i = 0; i < 3; i++) {
				long num = s;
				
				if (i == 0) num *= num;
				else if (i == 1) num <<= 1;
				else num = 1;
				
				if (visited.contains(num)) continue;
				
				deque.offer(new Node(num, i, head));
				visited.add(num);
			}
			
			Node resultNode = null;
			while (!deque.isEmpty()) {
				Node cur = deque.poll();
				
				if (cur.s == t) {
					resultNode = cur;
					break;
				}
				
				// '*'
				long ns = cur.s * cur.s;
				if (!visited.contains(ns) && ns <= t) {
					deque.offer(new Node(ns, 0, cur));
					visited.add(ns);
				}
				
				// '+'
				ns = cur.s << 1;
				if (!visited.contains(ns) && ns <= t) {
					deque.offer(new Node(ns, 1, cur));
					visited.add(ns);
				}
			}
			
			if (resultNode == null) {
				result = "-1";
				
			} else {
				StringBuilder sb = new StringBuilder();
				
				while (resultNode.pre != null) {
					if (resultNode.idx == 0) sb.append("*");
					else if (resultNode.idx == 1) sb.append("+");
					else sb.append("/");
					
					resultNode = resultNode.pre;
				}
				
				result = sb.reverse().toString();
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}