import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map.put(st.nextToken(), i);
        }

        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        String arr[] = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        for (int i = 0; i < N; i++) {
            for (int k = i + 1; k < N; k++) {
                if (map.get(arr[i]) < map.get(arr[k])) cnt++;
            }
        }

        System.out.println(cnt + "/" + (N * (N - 1) / 2));

        br.close();
    }
}