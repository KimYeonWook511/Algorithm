import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int A[] = new int[N << 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < (N << 1); i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        }
        
        int startIdx = 0;
        
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int size = 0;
        boolean chk[] = new boolean[N << 1];
        
        int step = 0;
        while (true) {
        	step++;
        	startIdx = (startIdx + (N << 1) - 1) % (N << 1);
        	
        	if (chk[(startIdx + N) % (N << 1)]) {
        		chk[deque.poll()] = false;
        		size--;
        	}
        	
        	if (chk[(startIdx + N - 1) % (N << 1)]) {
        		chk[deque.poll()] = false;
        		size--;
        	}
        	
        	int curIdx, nextIdx;
        	for (int i = 0; i < size; i++) {
        		curIdx = deque.poll();
        		nextIdx = (curIdx + 1) % (N << 1);
        		
        		if (chk[nextIdx] || A[nextIdx] == 0) {
        			deque.offer(curIdx);
        			continue;
        		}
        		
        		chk[curIdx] = false;
        		chk[nextIdx] = true;
        		deque.offer(nextIdx);
        		if (--A[nextIdx] == 0) K--;
        	}
        	
        	if (A[startIdx] != 0) {
        		deque.offer(startIdx);
        		size++;
        		chk[startIdx] = true;
        		
        		if (--A[startIdx] == 0) K--;
        	}
        	
        	if (K <= 0) break;
        }
        
        System.out.println(step);
        
        br.close();
    }
}