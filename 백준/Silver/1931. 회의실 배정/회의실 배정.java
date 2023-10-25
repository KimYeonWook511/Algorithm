import java.io.*;
import java.util.*;

class Lecture {
    int s;
    int e;

    public Lecture(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();

        StringTokenizer st;
        
        for (int run = 0; run < n; run++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(run, new Lecture(s, e));
        }

        Collections.sort(list, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o1.e == o2.e) return o1.s - o2.s;

                return o1.e - o2.e;
            }
        });

        int cnt = 0;
        int end = 0;

        for (Lecture lec : list) {
            if (lec.s >= end) {
                cnt++;
                end = lec.e;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}