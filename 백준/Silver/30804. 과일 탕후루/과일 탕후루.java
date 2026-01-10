import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int S[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int count[] = new int[10];
        int typeCount = 0;

        int left = 0;
        int answer = 0;
        for (int right = 0; right < N; right++) {
            // 오른쪽 과일 추가
            if (count[S[right]] == 0) {
                typeCount++;
            }
            count[S[right]]++;

            // 종류가 2개 초과하면 왼쪽 줄이기
            while (typeCount > 2) {
                count[S[left]]--;
                if (count[S[left]] == 0) {
                    typeCount--;
                }
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);

        br.close();
    }
}
