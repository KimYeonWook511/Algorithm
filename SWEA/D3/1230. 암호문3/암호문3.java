import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	String code;
	Node next;
	
	Node() {
	}
	
	Node(String code) {
		this.code = code;
	}

	Node(Node next) {
		this.next = next;
	}
	
	Node(String code, Node next) {
		this.code = code;
		this.next = next;
	}
}

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static Node head, tail;
	static char cmd;
	static int x, y;
	
	public static void main(String[] args) throws Exception {
        for (int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine());

            head = new Node();
            tail = new Node(head);
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	add(st.nextToken());
            }
            
            M = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            for (int run = 0; run < M; run++) {
            	cmd = st.nextToken().charAt(0);
            	
            	if (cmd == 'I') {
            		x = Integer.parseInt(st.nextToken());
            		y = Integer.parseInt(st.nextToken());
            		
            		for (int i = 0; i < y; i++) {
            			insert(x + i, st.nextToken());
            		}
            		
            	} else if (cmd == 'D') {
            		x = Integer.parseInt(st.nextToken());
            		y = Integer.parseInt(st.nextToken());
            		
            		for (int i = 0; i < y; i++) {
            			delete(x);
            		}
            		
            	} else {
            		y = Integer.parseInt(st.nextToken());
            		
            		for (int i = 0; i < y; i++) {
            			add(st.nextToken());
            		}
            	}
            }
            
            sb.append("#").append(t).append(" ");
            
            for (int i = 0; i < 10; i++) {
            	head = head.next;
            	sb.append(head.code).append(" ");
            }
            
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
	
	static void insert(int idx, String code) {
		Node node = new Node(code);
		Node pre = head;
		
		for (int i = 0; i < idx; i++) {
			pre = pre.next;
		}
		
		node.next = pre.next;
		pre.next = node;
	}
	
	static void delete(int idx) {
		Node pre = head;
		
		for (int i = 0; i < idx; i++) {
			pre = pre.next;
		}
		
		pre.next = pre.next.next;
//		pre.next.next = null; // 이렇게 하면 메모리를 아낄 수 있는가?
	}
	
	static void add(String code) {
		Node node = new Node(code);
		
		tail.next.next = node; // 헤드가 첫 노드 가르키기 and 마지막 노드가 새로운 노드 가르키기 
		tail.next = node; // 꼬리 노드가 가르키기
	}
}