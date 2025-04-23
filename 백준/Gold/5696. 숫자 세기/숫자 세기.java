import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());

            if (A == 0) break;

            int B = Integer.parseInt(st.nextToken());

            int cntA[] = new int[10];
            int cntB[] = new int[10];

            cal(A - 1, cntA);
            cal(B, cntB);

            for (int i = 0; i < 10; i++) {
                sb.append(cntB[i] - cntA[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void cal(int X, int cnt[]) {
        int weight = 1; // 자릿수
        int up = X / 10; // 윗수
        int down = 0; // 아랫수

        while (weight <= X) {
            int cur = X / weight % 10; // 현재 자릿수의 수

            // X=12345, weight=100 이라 가정 | 00(0)00~11(0)99, 00(1)00~11(1)99, ... , 00(9)00~11(9)99
            for (int i = 0; i < 10; i++) {
                cnt[i] += up * weight;
            }
            cnt[0] -= weight; // 00(0)00~00(0)99 빼기

            // X=12345, weight=100 이라 가정 | 12000~12299
            for (int i = 0; i < cur; i++) {
                cnt[i] += weight;
            }

            cnt[cur] += down + 1; // cur의 등장 횟수 ex) X=12345, weight=100 이라 가정 | 12300~12345 = 45 + 1번

            up /= 10;
            down += cur * weight;
            weight *= 10;
        }
    }
}