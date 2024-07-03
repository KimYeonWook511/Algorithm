import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int arr[] = new int[H + 1];
        for (int i = 0; i < N; i++) {
        	if (i % 2 == 0) arr[Integer.parseInt(br.readLine()) + 1]--;
        	else arr[H - Integer.parseInt(br.readLine()) + 1]++;
        }
        
        int val = N >> 1;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> cntMap = new HashMap<>();
        
        for (int i = 0; i < H; i++) {
        	val += arr[i];
        	min = Math.min(min, val);
        	
        	cntMap.put(val, cntMap.getOrDefault(val, 0) + 1);
        }
        
        System.out.println(min + " " + cntMap.get(min));

        br.close();
    }
}