import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        List<Long> list = new ArrayList<>();

        // 비트 켜진것이 골라진 숫자 (0~9 총 10개의 비트 사용)
        for (int i = (1 << 10) - 1; i > 0; i--) {
            long num = 0;

            // 높은 수 부터 앞으로
            for (int k = 9; k >= 0; k--) {
                if ((i & (1 << k)) == 0) continue;

                num = num * 10 + k;
            }

            list.add(num);
        }

        Collections.sort(list);

        System.out.println(N >= list.size() ? "-1" : list.get(N));

        br.close();
    }
}