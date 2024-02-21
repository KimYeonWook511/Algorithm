import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, idx, nodeCnt[];
	static String king, pa1, pa2, child, cur, maxName, nodeName[];
	static List<Integer> graph[];
	static Map<String, Integer> nodeIdx = new HashMap<>(); // 노드의 인덱스 map
	static Deque<Integer> deque = new ArrayDeque<>();
	static double max, nodeValue[];
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N << 1];
		nodeName = new String[N << 1];
		nodeValue = new double[N << 1];
		nodeCnt = new int[N << 1];
		
		for (int i = (N << 1) - 1; i >= 0; i--) {
			graph[i] = new ArrayList<>();
			nodeCnt[i] = -1;
		}
		
		king = br.readLine();
		nodeIdx.put(king, idx);
		nodeName[idx] = king;
		nodeCnt[idx] = 0;
		nodeValue[idx++] = 1.0;
		
		for (int run = 0; run < N; run++) {
			st = new StringTokenizer(br.readLine());
			child = st.nextToken();
			pa1 = st.nextToken();
			pa2 = st.nextToken();
			
			if (!nodeIdx.containsKey(child)) {
				nodeIdx.put(child, idx);
				nodeName[idx++] = child;
			}
			
			nodeCnt[nodeIdx.get(child)] = 2; // = 2로도 해보기
			
			if (!nodeIdx.containsKey(pa1)) {
				nodeIdx.put(pa1, idx);
				nodeName[idx] = pa1;
				nodeCnt[idx++] = 0;
			}
			
			graph[nodeIdx.get(pa1)].add(nodeIdx.get(child));
				
			
			if (!nodeIdx.containsKey(pa2)) {
				nodeIdx.put(pa2, idx);
				nodeName[idx] = pa2;
				nodeCnt[idx++] = 0;
			}
			
			graph[nodeIdx.get(pa2)].add(nodeIdx.get(child));
				
		}
		
		for (int i = (N << 1) - 1; i >= 0; i--) {
			if (nodeCnt[i] == 0) deque.offerLast(i);
		}
		
		while (!deque.isEmpty()) {
			idx = deque.poll();
			
			for (int childIdx : graph[idx]) {
				if ((nodeCnt[childIdx] -= 1) == 0) deque.offerLast(childIdx);
				
				nodeValue[childIdx] += nodeValue[idx] / 2;
			}
		}
		
		for (int i = 0; i < M; i++) {
			cur = br.readLine();
			
			double val = nodeIdx.containsKey(cur) ? nodeValue[nodeIdx.get(cur)] : -1;
			
			if (val > max) {
				max = val;
				maxName = cur;
			}
		}
		
		System.out.println(maxName);
		
		br.close();
	}
}