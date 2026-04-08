import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        // 행 검사
        for (int r = 0; r < N; r++) {
            boolean isCan = true;
            int cnt = 1;
            for (int c = 1; c < N; c++) {
                if (map[r][c] == map[r][c - 1]) {
                    cnt++;
                } else if (map[r][c] == map[r][c - 1] + 1) {
                    if (cnt < L) {
                        isCan = false;
                        break;
                    }
                    cnt = 1;
                } else if (map[r][c] == map[r][c - 1] - 1) {
                    for (int i = 1; i < L; i++) {
                        if (c + i >= N || map[r][c + i] != map[r][c - 1] - 1) {
                            isCan = false;
                            break;
                        }
                    }
                    if (!isCan) break;

                    cnt = 0;
                    c += (L - 1); // for문 값 보정
                } else {
                    isCan = false;
                    break;
                }
            }

            if (isCan) answer++;
        }

        // 열 검사
        for (int c = 0; c < N; c++) {
            boolean isCan = true;
            int cnt = 1;
            for (int r = 1; r < N; r++) {
                if (map[r][c] == map[r - 1][c]) {
                    cnt++;
                } else if (map[r][c] == map[r - 1][c] + 1) {
                    if (cnt < L) {
                        isCan = false;
                        break;
                    }
                    cnt = 1;
                } else if (map[r][c] == map[r - 1][c] - 1) {
                    for (int i = 1; i < L; i++) {
                        if (r + i >= N || map[r + i][c] != map[r - 1][c] - 1) {
                            isCan = false;
                            break;
                        }
                    }
                    if (!isCan) break;

                    cnt = 0;
                    r += (L - 1); // for문 값 보정
                } else {
                    isCan = false;
                    break;
                }
            }

            if (isCan) answer++;
        }

        System.out.println(answer);

        br.close();
    }
}