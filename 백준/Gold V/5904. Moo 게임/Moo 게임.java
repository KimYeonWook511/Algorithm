import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = 0;
        int len = 3;

        while (true) {
            k = 0;
            len = 3;

            while (len < N) {
                // 다음 f의 막대 길이 구하기
                k++;
                len <<= 1;
                len += k + 3; // 1 + k + 2
            }
            N -= (len - (k + 3)) >> 1; // 전체 막대에서 좌측 빼기

            // 현재 막대의 중간 값(m + o*(k + 2) -> 1 + (k + 2))에 포함한다는 뜻
            if (N == 1) {
                System.out.println("m");

                break;

            } else if (N <= k + 3) {
                System.out.println("o");

                break;
            }

            N -= k + 3;
        }

        br.close();
    }
}