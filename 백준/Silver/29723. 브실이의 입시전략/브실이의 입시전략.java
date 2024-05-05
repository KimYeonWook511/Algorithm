import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < split[0]; i++) {
          String[] score = br.readLine().split(" ");
          map.put(score[0], Integer.parseInt(score[1]));
        }
    
        int base = 0;
        for (int i = 0; i < split[2]; i++) {
          String selected = br.readLine();
          base += map.get(selected);
          map.remove(selected);
        }
    
        int max = 0;
        int min = 0;
        List<Integer> maxList = new ArrayList<>(map.values());
        List<Integer> minList = new ArrayList<>(map.values());
        Collections.sort(maxList, Collections.reverseOrder());
        Collections.sort(minList);
        int compare = split[1] - split[2];
        for (int i = 0; i < compare; i++) {
          max += maxList.get(i);
          min += minList.get(i);
        }
    
        System.out.println((base + min + " " + (base + max)));
    }
}