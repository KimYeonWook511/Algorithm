import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int A = 0;

        for (int i = 1; i <= N; i++) {
            set.add(A);
            int temp = A - i;

            if (temp < 0 || set.contains(temp)) temp = A + i;

            A = temp;
        }

        System.out.println(A);

        br.close();
    }
}