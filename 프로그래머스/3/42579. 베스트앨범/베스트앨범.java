import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, List<int[]>> mapList = new HashMap<>();
        int rank[][] = new int[100][2];
        int rankIndex = 0;
        for (int i = 0; i < genres.length; i++) {
            int cur = map.getOrDefault(genres[i], -1);
            List<int[]> list = cur == -1 ? new ArrayList<>() : mapList.get(cur);
            if (cur == -1) {
                cur = rankIndex;
                map.put(genres[i], rankIndex++);
                mapList.put(cur, list);
            }
            
            rank[cur][0] = cur;
            rank[cur][1] += plays[i];
            list.add(new int[]{i, plays[i]});
        }
        
        Arrays.sort(rank, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]) {
                // if (o1[1] == o2[1]) 
                return -Integer.compare(o1[1], o2[1]);
            }
        });
        
        for (Map.Entry<Integer, List<int[]>> entry : mapList.entrySet()) {
            List<int[]> list = entry.getValue();
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int o1[], int o2[]) {
                    if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
                    return -Integer.compare(o1[1], o2[1]);
                }
            });
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rankIndex; i++) {
            List<int[]> list = mapList.get(rank[i][0]);
            for (int j = 0; j < 2; j++) {
                if (list.size() >= j + 1) {
                    result.add(list.get(j)[0]);
                }
            }
        }
        
        int answer[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}