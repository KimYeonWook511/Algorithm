import java.io.*;
import java.util.*;

public class Main {
    static class Room {
        int t;
        long a, h;

        Room (int t, long a, long h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        Room rooms[] = new Room[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(t, a, h);
        }

        long left = 1;
        long right = Long.MAX_VALUE; // 10^12*123,456
        while (left <= right) {
            long mid = left + (right - left) / 2;

            long hp = mid;
            long attack = H;
            for (int i = 0; i < N; i++) {
                Room room = rooms[i];

                if (room.t == 1) {
                    hp -= ((room.h - 1) / attack) * room.a;

                    if (hp <= 0) {
                        break;
                    }

                } else {
                    attack += room.a;
                    hp = Math.min(mid, hp + room.h);
                }
            }

            if (hp <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);

        br.close();
    }
}