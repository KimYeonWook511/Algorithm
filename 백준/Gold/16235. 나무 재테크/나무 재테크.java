import java.io.*;
import java.util.*;

public class Main {
	static class Tree {
		int r, c, age;
		
		Tree (int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}
	}
	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int add[][] = new int[N][N];
        int arr[][] = new int[N][N];
        for (int r = 0; r < N; r++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int c = 0; c < N; c++) {
        		add[r][c] = Integer.parseInt(st.nextToken());
        		arr[r][c] = 5;
        	}
        }
        
        PriorityQueue<Tree> pq = new PriorityQueue<>(new Comparator<Tree>() {
        	@Override
        	public int compare(Tree o1, Tree o2) {
        		return Integer.compare(o1.age, o2.age);
        	}
		});
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	pq.offer(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }
        
        Deque<Tree> deadDeque = new ArrayDeque<>();
        Deque<Tree> aliveDeque = new ArrayDeque<>();
        Tree cur;
        
        for (int day = 0; day < K; day++) {
        	while (!pq.isEmpty()) {
        		cur = pq.poll();
        		
        		if (arr[cur.r][cur.c] + add[cur.r][cur.c] * day < cur.age) {
        			deadDeque.offer(cur);
        			continue;
        		}
        		
        		arr[cur.r][cur.c] -= cur.age;
        		cur.age++;
        		aliveDeque.offer(cur);
        	}
        	
        	while (!deadDeque.isEmpty()) {
        		cur = deadDeque.poll();
        		arr[cur.r][cur.c] += (cur.age >> 1); 
        	}
        	
        	while (!aliveDeque.isEmpty()) {
        		cur = aliveDeque.poll();

        		if (cur.age % 5 == 0) {
        			int nr, nc;
        			for (int d = 0; d < 8; d++) {
        				nr = cur.r + dr[d];
        				nc = cur.c + dc[d];
        				
        				if (nr < 0 || nc < 0) continue;
        				if (nr >= N || nc >= N) continue;
        				
        				pq.offer(new Tree(nr, nc, 1));
        			}
        		}

        		pq.offer(cur);
        	}
        }
        
        System.out.println(pq.size());
        
        br.close();
    }
}