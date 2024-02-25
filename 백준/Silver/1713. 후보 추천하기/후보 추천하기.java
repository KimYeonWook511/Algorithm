import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Student {
        int cnt;
        int i;

        Student(int cnt, int i) {
            this.cnt = cnt;
            this.i = i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Student arr[] = new Student[101];
        for (int i = 100; i > 0; i--) {
            arr[i] = new Student(0, 0);
        }

        PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.cnt == o2.cnt) return -Integer.compare(o1.i, o2.i);

                return Integer.compare(o1.cnt, o2.cnt);
            }
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = M; i > 0; i--) {
            int num = Integer.parseInt(st.nextToken());
            
            arr[num].cnt++;

            if (arr[num].cnt == 1) { // 현재 큐에 존재하지 않음
                if (pq.size() >= N) pq.poll().cnt = 0;

                arr[num].i = i;
                pq.offer(arr[num]);

            } else {
                pq.remove(arr[num]);
                pq.offer(arr[num]);
            }
        }

        for (int i = 1; i <= 100; i++) {
            if (arr[i].cnt > 0) sb.append(i).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}