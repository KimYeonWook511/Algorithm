import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        Set<Integer> set = new HashSet<>();

        for (int i1 = 0; i1 < N; i1++) {
            for (int i2 = i1; i2 < N; i2++) {
                set.add(arr[i1] + arr[i2]);
            }
        }

        for (int t = N - 1; t >= 0; t--) {
            for (int i = 0; i < N; i++) {
                if (set.contains(arr[t] - arr[i])) {
                    System.out.println(arr[t]);
                    t = 0;
                    break;
                }
            }
        }
        
        br.close();
    }
}