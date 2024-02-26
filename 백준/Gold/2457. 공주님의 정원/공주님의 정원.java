import java.io.*;
import java.util.*;

public class Main {

	static int MD[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	static class Project { 
		int start, end;
		
		Project (int startM, int startD, int endM, int endD) {
			start = startD;
			for (int i = 1; i < startM; i++) {
				start += MD[i];
			}
			
			end = endD;
			for (int i = 1; i < endM; i++) {
				end += MD[i];
			}
		}

        @Override
        public String toString() {
            return "start: " + start + " | end: " + end; 
        }
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Project arr[] = new Project[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Project(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr, new Comparator<Project>() {
			@Override
			public int compare(Project o1, Project o2) {
				return Integer.compare(o1.start, o2.start);
			}
		});

		PriorityQueue<Project> pq = new PriorityQueue<>(new Comparator<Project>() {
			@Override
			public int compare(Project o1, Project o2) {
				return -Integer.compare(o1.end, o2.end);
			}
		});
		
		pq.offer(arr[0]);
		boolean flag = pq.peek().start > 60 ? false : true;
		
        if (flag) {
            for (int i = 1; i < N; i++) {
                if (arr[i].start <= 60) {
                    if (arr[i].end <= pq.peek().end) continue;
                    
                    pq.poll();
                    pq.offer(arr[i]);
    
                } else if (arr[i].start > pq.peek().end) {
                    // 중간에 빔
                    flag = false;
                    break;
    
                } else if (arr[i].end > pq.peek().end) {
                    Project cur;
    
                    while (true) {
                        cur = pq.poll();
    
                        if (pq.isEmpty()) break;
                        if (arr[i].start > pq.peek().end) break;
                    }
    
                    pq.offer(cur);
                    if (arr[i].end > pq.peek().end) pq.offer(arr[i]);
                }
    
                if (pq.peek().end > 334) break;
            }
        }
        
		System.out.println(flag && pq.peek().end > 334? pq.size() : "0");
		
		br.close();
	}
}