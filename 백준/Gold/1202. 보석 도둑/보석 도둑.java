import java.io.*;
import java.util.*;

public class Main {
    static class Jewel {
        int M, V;

        Jewel (int M, int V) {
            this.M = M;
            this.V = V;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Jewel arr[] = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Integer C[] = new Integer[K];
        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                // 어차피 아래서 같은 무게 보석에 대해 가치 확인을 다시 하게 됨
                // 그래서 if문을 따로 또 안 씀
                return -Integer.compare(o1.M, o2.M);
            }
        });

        Arrays.sort(C, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        long result = 0;
        int CIdx = 0;
        for (int i = 0; i < N; i++) {
            if (CIdx >= K || arr[i].M > C[CIdx]) {
                if (pq.isEmpty()) continue;
                if (pq.peek() >= arr[i].V) continue;
                
                result -= pq.poll();
                CIdx--;
            }

            result += arr[i].V;
            pq.offer(arr[i].V);
            CIdx++;
        }

        System.out.println(result);

        br.close();
    }
}