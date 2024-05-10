import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();

        int ans = 0;
        
        for (int i = 0; i < N; i++) {
        	String cur = br.readLine();
        	
            if (cnt - map.getOrDefault(cur, 0) < map.getOrDefault(cur, 0)) ans++;
            
            cnt++;
            map.put(cur, map.getOrDefault(cur, 0)+1);	
        }
        
        System.out.println(ans);
        
        br.close();
    }
}