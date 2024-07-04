import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int i, w;
		
		Node (int i, int w) {
			this.i = i;
			this.w = w;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        List<Node> graph[] = new ArrayList[V + 1];
        int minM[] = new int[V + 1];
        int minS[] = new int[V + 1];
        
        for (int i = 1; i <= V; i++) {
        	graph[i] = new ArrayList<>();
        	minM[i] = Integer.MAX_VALUE;
        	minS[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	graph[u].add(new Node(v, w));
        	graph[v].add(new Node(u, w));
        }
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int arrM[] = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
        	arrM[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int arrS[] = new int[S];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
        	arrS[i] = Integer.parseInt(st.nextToken());
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        	@Override
        	public int compare(Node o1, Node o2) {
        		return Integer.compare(o1.w, o2.w);
        	}
		});
        Node cur;
        
        for (int i = 0; i < M; i++) {
        	pq.offer(new Node(arrM[i], 0));
        	minM[arrM[i]] = 0;
        }
        
        while (!pq.isEmpty()) {
        	cur = pq.poll();
        	
    		if (minM[cur.i] < cur.w) continue;
    		
    		for (Node next : graph[cur.i]) {
        		if (cur.w + next.w > x) continue;
        		if (cur.w + next.w >= minM[next.i]) continue;
        		
        		pq.offer(new Node(next.i, cur.w + next.w));
        		minM[next.i] = cur.w + next.w;
        	}
        }
        
        for (int i = 0; i < S; i++) {
        	pq.offer(new Node(arrS[i], 0));
        	minS[arrS[i]] = 0;
        }
        
        while (!pq.isEmpty()) {
        	cur = pq.poll();
        	
    		if (minS[cur.i] < cur.w) continue;
    		
    		for (Node next : graph[cur.i]) {
        		if (cur.w + next.w > y) continue;
        		if (cur.w + next.w >= minS[next.i]) continue;
        		
        		pq.offer(new Node(next.i, cur.w + next.w));
        		minS[next.i] = cur.w + next.w;
        	}
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
        	if (minM[i] == Integer.MAX_VALUE) continue;
        	if (minS[i] == Integer.MAX_VALUE) continue;
        	if (minM[i] == 0) continue;
        	if (minS[i] == 0) continue;
        	
        	min = Math.min(min, minM[i] + minS[i]);
        }
        
        System.out.println(min == Integer.MAX_VALUE ? "-1" : min);
        
        br.close();
    }
}