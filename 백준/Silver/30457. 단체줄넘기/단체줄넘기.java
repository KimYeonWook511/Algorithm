import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            map.put(A, map.getOrDefault(A, 0) + 1);
        }

        int result = 0;
        for (int value : map.values()) {
            result += Math.min(value, 2);
        }

        System.out.println(result);
        
        br.close();
    }
}