import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        func(list, 0, N - 1);

        System.out.println(max);

        br.close();
    }

    static void func(List<Integer> list, int sum, int end) {
        if (end == 1) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < end; i++) {
            int val = list.get(i - 1) * list.get(i + 1);
            int temp = list.get(i);
            list.remove(i);
            func(list, sum + val, end - 1);
            list.add(i, temp);
        }
    }
}