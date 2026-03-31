import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (t == 3) {
                small.add(s);
            } else {
                large.add(s);
            }
        }

        Collections.sort(small, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        Collections.sort(large, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        long smallSum[] = new long[small.size() + 1];
        int count = 0;
        for (Integer s : small) {
            count++;
            if (3 * count > w) break;
            smallSum[count] = smallSum[count - 1] + s;
        }

        long largeSum[] = new long[large.size() + 1];
        count = 0;
        for (Integer l : large) {
            count++;
            if (5 * count > w) break;
            largeSum[count] = largeSum[count - 1] + l;
        }

        long answer = 0;
        for (int l = 0; l <= w; l += 5) {
            int largeCount = l / 5;
            if (largeCount > large.size()) break;
            
            int smallCount = Math.min(small.size(), (w - l) / 3);
            answer = Math.max(answer, largeSum[largeCount] + smallSum[smallCount]);
        }

        System.out.println(answer);

        br.close();
    }
}