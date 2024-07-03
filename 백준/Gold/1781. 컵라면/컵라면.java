import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return Integer.compare(o1[0], o2[0]);
        	}
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		return Integer.compare(o1, o2);
        	}
		});
        
        int size = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
        	if (arr[i][0] > size) {
        		pq.offer(arr[i][1]);
        		size++;
        		sum += arr[i][1];
        		continue;
        	}
        	
        	if (pq.peek() >= arr[i][1]) continue;
        	
        	sum -= pq.poll();
        	pq.offer(arr[i][1]);
        	sum += arr[i][1];
        }
        
        System.out.println(sum);
        
        br.close();
    }
}