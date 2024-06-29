import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int C = Integer.parseInt(br.readLine());
        int D[] = new int[N];

        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(D);

        int price = A;
        int kcal = C;
        int result = kcal / price;

        for (int i = N - 1; i >= 0; i--) {
            price += B;
            kcal += D[i];

            int cal = kcal / price;

            if (result > cal) break;

            result = cal;
        }

        System.out.println(result);

        br.close();
    }
}