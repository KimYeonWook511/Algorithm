import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        float total = 0;
        
        while (true) {
            String str = br.readLine();

            if (str == null) break;
            
            map.put(str, map.getOrDefault(str, 0) + 1);
            total++;
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);

            sb.append(key).append(" ").append(String.format("%.4f", map.get(key) / total * 100)).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}