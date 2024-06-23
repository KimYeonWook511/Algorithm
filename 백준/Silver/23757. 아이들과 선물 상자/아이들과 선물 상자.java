import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		return -Integer.compare(o1, o2);
        	}
		});
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	pq.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        boolean flag = true;
        int w = 0;
        int a = 0;
        
        for (int i = 0; i < M; i++) {
        	w = Integer.parseInt(st.nextToken());
        	
        	if (pq.isEmpty()) {
        		flag = false;
        		break;
        	}
        	
        	a = pq.poll();
        	
        	if (w > a) {
        		flag = false;
        		break;
        	}
        	
        	pq.offer(a - w);
        }
        
        System.out.println(flag ? "1" : "0");
        
        br.close();
    }
}