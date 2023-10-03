import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Set<String> set = new HashSet<>();
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        String arr[] = st.nextToken().split(":");
        int s = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);

        arr = st.nextToken().split(":");
        int e = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);

        arr = st.nextToken().split(":");
        int q = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);

        while (true) {
            String str = br.readLine();

            if (str == null || str.length() == 0) break;

            st = new StringTokenizer(str);
            arr = st.nextToken().split(":");
            int m = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
            str = st.nextToken();

            if (m <= s) {
                set.add(str);

            } else if (m >= e && m <= q && set.contains(str)) {
                set.remove(str);
                cnt++;
            } 
        }

        System.out.println(cnt);

        br.close();
    }
}