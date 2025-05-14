import java.io.*;
import java.util.*;

public class Main {
    static class People {
        int t1, t2;
        boolean isWaiting;

        People (int t1, int t2) {
            this.t1 = t1;
            this.t2 = t2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        People sortArr[] = new People[N];
        People p[] = new People[200_001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            People people = new People(t1, t2);
            sortArr[i] = people;

            p[t1] = people;
        }

        Arrays.sort(sortArr, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.t2 == o2.t2) return Integer.compare(o1.t1, o2.t1);

                return Integer.compare(o1.t2, o2.t2);
            }
        });

        Deque<People> dq = new ArrayDeque<>();
        int result = 0;
        int time = 1;
        for (int i = 0; i < N; i++) {
            People cur = sortArr[i];

            if (cur.t2 == time) {
                cur.isWaiting = true;
                dq.offer(cur);

            } else if (cur.t2 > time) {
                if (p[time] != null && p[time].isWaiting) {
                    result = Math.max(result, time - p[time].t2);
                    p[time].isWaiting = false;

                } else {
                    while (!dq.isEmpty()) {
                        People temp = dq.poll();

                        if (temp.isWaiting) {
                            result = Math.max(result, time - temp.t2);
                            temp.isWaiting = false;
                            break;
                        }
                    }
                }

                time++;
                i--; // 같은 sortArr을 확인해야함
            }
        }

        while (!dq.isEmpty()) {
            if (time <= 200_000 && p[time] != null && p[time].isWaiting) {
                result = Math.max(result, time - p[time].t2);
                p[time].isWaiting = false;

            } else {
                while (!dq.isEmpty()) {
                    People temp = dq.poll();

                    if (temp.isWaiting) {
                        result = Math.max(result, time - temp.t2);
                        temp.isWaiting = false;
                        break;
                    }
                }
            }

            time++;
        }

        System.out.println(result);

        br.close();
    }
}