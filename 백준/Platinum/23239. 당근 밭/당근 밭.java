import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long w = Long.parseLong(st.nextToken());
        long h = Long.parseLong(st.nextToken());
        long l = Long.parseLong(st.nextToken());

        long result = 0;

        // 좌측 하단 기준
        long r1 = l;
        for (long x = 1; x < r1; x++) {
            result += (long)Math.sqrt(r1 * r1 - x * x);
        }
        result = result * 3 + 2 * l; // 반지름 두 개 당근 추가

        // 좌측 상단 기준
        long r2 = l - h;
        for (long x = 1; x < r2; x++) {
            result += (long)Math.sqrt(r2 * r2 - x * x);
        }
        result += Math.max(0, l - h); // 반지름 한 개 당근 추가
        
        // 우측 하단 기준
        long r3 = l - w;
        for (long x = 1; x < r3; x++) {
            result += (long)Math.sqrt(r3 * r3 - x * x);
        }
        result += Math.max(0, l - w); // 반지름 한 개 당근 추가

        if (l > w + h) {
            // 이하 중첩 부분 당근 빼기

            long maxX = 0; // 겹치는 교점의 바로 다음 점 - 1 == 겹치는 부분의 가로
            long maxY = 0; // 겹치는 교점의 바로 다음 점 - 1 == 겹치는 부분의 세로

            // 좌측 상단 기준
            for (int x = 1; x < r2; x++) {
                double x3 = Math.sqrt(r2 * r2 - x * x) - w;
                double y3 = h + x;

                if (x3 * x3 + y3 * y3 < r3 * r3) result -= (long)x3;
                else {
                    maxY = (long)y3 - 1; 
                    break;
                }
            }

            // 우측 하단 기준
            for (long x = 1; x < r3; x++) {
                double x2 = Math.sqrt(r3 * r3 - x * x) - h;
                double y2 = w + x;

                if (x2 * x2 + y2 * y2 < r2 * r2) result -= (long)x2;
                else {
                    maxX = (long)y2 - 1;
                    break;
                }
            }
            
            result += (maxX - w) * (maxY - h);
        }

        System.out.println(result);

        br.close();
    }
}