import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (st.nextToken().charAt(0) == '1') arr[i] = true;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (!arr[i]) continue;

            arr[i + 1] = !arr[i + 1];
            arr[i + 2] = !arr[i + 2];
            result++;
        }
		
		System.out.println(result);

        br.close();
    }
}