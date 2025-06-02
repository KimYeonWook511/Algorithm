import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String names[] = new String[N];
        Map<String, Integer> namesMap = new HashMap<>();
        List<Integer> graph[] = new ArrayList[N];
        List<String> childList[] = new ArrayList[N];
        int inDegree[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();

            names[i] = name;
            namesMap.put(name, i);
            graph[i] = new ArrayList<>();
            childList[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idxX = namesMap.get(st.nextToken());
            int idxY = namesMap.get(st.nextToken());

            graph[idxY].add(idxX);
            inDegree[idxX]++;
        }

        List<String> rootList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                deque.offer(i);
                rootList.add(names[i]);
            }
        }

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int child : graph[cur]) {
                if (--inDegree[child] == 0) {
                    deque.offer(child);
                    childList[cur].add(names[child]);
                }
            }
        }

        // root 출력 작업
        Collections.sort(rootList);
        sb.append(rootList.size()).append("\n");
        for (String name : rootList) {
            sb.append(name).append(" ");
        }
        sb.append("\n");

        // 자식 출력 작업
        String keys[] = namesMap.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        for (String name : keys) {
            int nameIdx = namesMap.get(name);
            List<String> list = childList[nameIdx];
            
            Collections.sort(list);
            sb.append(name).append(" ").append(list.size()).append(" ");
            for (String childName : list) {
                sb.append(childName).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}