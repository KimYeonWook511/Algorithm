import java.io.*;

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static int calArr[];
    static char arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        arr = new char[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = str.charAt(i - 1);
        }

        func(3, arr[1] - '0');

        System.out.println(max);

        br.close();
    }

    public static void func(int i, int val) {
        if (i == N) {
            max = Math.max(max, cal(val, arr[i] - '0', arr[i - 1]));

            return;
        }

        if (i > N) {
            max = Math.max(max, val);

            return;
        }

        // 그냥 연산과
        func(i + 2, cal(val, arr[i] - '0', arr[i - 1]));
        // 괄호 연산
        func(i + 4, cal(val, cal(arr[i] - '0', arr[i + 2] - '0', arr[i + 1]), arr[i - 1]));
    }

    public static int cal(int op1, int op2, char operator) {
        if (operator == '+') {
            op1 += op2;

        } else if (operator == '-') {
            op1 -= op2;

        } else {
            // '*'
            op1 *= op2;
        }

        return op1;
    }
}