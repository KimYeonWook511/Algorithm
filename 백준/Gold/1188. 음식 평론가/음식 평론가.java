import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

        System.out.println(M - func(N, M));

        br.close();
    }

	static int func(int a, int b) {
        if (a % b == 0) return b;

		return func(b, a % b);
	}
}