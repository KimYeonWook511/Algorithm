import java.io.*;
import java.util.*;

public class Main {
    static class Customer {
        long id;
        int w;
        long no; // 계산대 번호

        Customer (long id, int w, long no) {
            this.id = id;
            this.w = w;
            this.no = no;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Customer> pq = new PriorityQueue<>(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                if (o1.w == o2.w) return -Long.compare(o1.no, o2.no);

                return Integer.compare(o1.w, o2.w);
            }
        });

        Customer arr[] = new Customer[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Customer(Long.parseLong(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        }

        int cnt = 1;
        int temp = 0;
        long result = 0;
        Customer cur = null;
        PriorityQueue<Long> noPq = new PriorityQueue<>();

        if (N <= k) {
            for (int i = 1; i <= N; i++) {
                arr[i].no = i;
                pq.offer(arr[i]);
            }

        } else {
            for (int i = 1; i <= k; i++) {
                arr[i].no = i;
                pq.offer(arr[i]);
            }

            int i = k + 1;

            while (!pq.isEmpty()) {
                if (i > N) break;

                cur = pq.poll();
                temp = cur.w;
                result += cnt * cur.id;
                cnt++;
                noPq.offer(cur.no);

                while (!pq.isEmpty()) {
                    if (pq.peek().w > temp) break;
    
                    cur = pq.poll();
                    result += cnt * cur.id;
                    cnt++;
                    noPq.offer(cur.no);
                }

                while (!noPq.isEmpty()) {
                    if (i > N) break;

                    arr[i].no = noPq.poll();
                    arr[i].w += temp;
                    pq.offer(arr[i]);
                    i++;
                }
            }
        }

        while (!pq.isEmpty()) {
            result += cnt * pq.poll().id;
            cnt++;
        }

        System.out.println(result);

        br.close();
    }
}