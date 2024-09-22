import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(func(N, 1) + func(N, 2));

        br.close();
    }

    static long func(int N, int num) {
        if (N == 1) return num % 3 == 0 ? 1 : 0;

        long sum = 0;
        for (int i = 0; i < 3; i++) {
            int temp = num * 10 + i;
            sum += func(N - 1, temp);
        }

        return sum;
    }
}