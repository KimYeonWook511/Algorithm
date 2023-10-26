import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        int sqrt = (int)Math.sqrt(n);

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                list.add(i);

                if (n / i != i) list.add(n / i);
            }
        }

        int size = list.size();

        if (k > size) System.out.println(0);
        else if (k > (size + 1) / 2) System.out.println(list.get(1 + 2 * (size - k)));
        else System.out.println(list.get(2 * (k - 1)));

        br.close();
    }
}