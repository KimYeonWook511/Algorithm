import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            char arr[] = st.nextToken().toCharArray();
            int len = arr.length;
            int cnt = Integer.parseInt(st.nextToken());

            Map<Integer, Set<String>> map = new HashMap<>();
            Set<String> set;

            for (int i = 0; i <= cnt; i++) {
                map.put(i, new HashSet<>());
            }

            map.get(0).add(String.valueOf(arr));

            for (int run = 0; run < cnt; run++) {
                set = map.get(run);

                for (String num : set) {
                    arr = num.toCharArray();
    
                    for (int i = 0; i < len; i++) {
                        for (int k = i + 1; k < len; k++) {
                            char temp = arr[i];
                            arr[i] = arr[k];
                            arr[k] = temp;
                            
                            map.get(run + 1).add(String.valueOf(arr));

                            arr[k] = arr[i];
                            arr[i] = temp;
                        }
                    }
                }
            }

            set = map.get(cnt);
            int max = 0;

            for (String num : set) {
                max = Math.max(max, Integer.parseInt(num));
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}