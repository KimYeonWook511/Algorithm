import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		Node prev, next;
		int i;
		
		Node (int i) {
			this.i = i;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		Node arr[] = new Node[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rank = Integer.parseInt(st.nextToken());
		arr[rank] = new Node(rank);
		Node head = arr[rank];
		Node tail = arr[rank];
		for (int i = 1; i < N; i++) {
			rank = Integer.parseInt(st.nextToken());
			arr[rank] = new Node(rank);
			tail.next = arr[rank];
			arr[rank].prev = tail;
			tail = arr[rank];
		}
		
		int sum = 0;
		for (int i = N; i > 1; i--) {
			Node cur = arr[i];
			
			if (cur.prev == null) sum += Math.abs(cur.i - cur.next.i); // 맨 왼쪽
			else if (cur.next == null) sum += Math.abs(cur.i - cur.prev.i); // 맨 오른쪽
			else sum += Math.min(Math.abs(cur.i - cur.prev.i), Math.abs(cur.i - cur.next.i)); // 중간
			
			if (cur.prev == null) head = cur.next; // cur이 head인 경우
			else cur.prev.next = cur.next;
			
			if (cur.next == null) tail = cur.prev; // cur이 tail인 경우
			else cur.next.prev = cur.prev;
			
			arr[i] = null; // 노드 제거
		}
		
		System.out.println(sum);

		br.close();
	}
}