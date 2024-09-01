import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        int size = 0;
        map.put(A, size++);
        int pre = A;
        
        while (true) {
            int temp = pre;
            int result = 0;

            while(true) {
                if (temp == 0) break;

                result += (int)Math.pow(temp % 10, P);
                temp /= 10;
            }

            if (map.containsKey(result)) {
                System.out.println(map.get(result));
                break;
            }

            map.put(result, size++);
            pre = result;
        }

        br.close();
    }
}