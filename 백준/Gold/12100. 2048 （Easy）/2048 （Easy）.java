import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                answer = Math.max(answer, arr[r][c]);
            }
        }

        func(arr, 0, answer);

        System.out.println(answer);

        br.close();
    }

    static void func(int arr[][], int cnt, int max) {
        if (cnt == 5) {
            answer = Math.max(answer, max);
            return;
        }

        // 가지치기
        if (answer >= (max << (5 - cnt))) return;

        int cpArr[][] = new int[N][N];
        int nextMax = 0;

        // 우측
        cover(arr, cpArr);
        nextMax = moveRight(cpArr);
        func(cpArr, cnt + 1, Math.max(max, nextMax));

        // 좌측
        cover(arr, cpArr);
        nextMax = moveLeft(cpArr);
        func(cpArr, cnt + 1, Math.max(max, nextMax));

        // 위
        cover(arr, cpArr);
        nextMax = moveUp(cpArr);
        func(cpArr, cnt + 1, Math.max(max, nextMax));

        // 아래
        cover(arr, cpArr);
        nextMax = moveDown(cpArr);
        func(cpArr, cnt + 1, Math.max(max, nextMax));
    }

    static void cover(int arr[][], int target[][]) {
        for (int r = 0; r < N; r++) {
            // System.arraycopy(arr[r], 0, target[r], 0, N);
            for (int c = 0; c < N; c++) {
                target[r][c] = arr[r][c];
            }
        }
    }

    static int moveRight(int arr[][]) {
        int max = 0;
        for (int r = 0; r < N; r++) {
            int lastMerge = -1;
            for (int c = N - 2; c >= 0; c--) {
                int col = c;
                while (col <= N - 2) {
                    if (arr[r][col + 1] != 0) {
                        if ((col + 1 != lastMerge) && (arr[r][col + 1] == arr[r][col])) {
                            arr[r][col + 1] <<= 1;
                            arr[r][col] = 0;
                            lastMerge = col + 1;
                            max = Math.max(max, arr[r][col + 1]);
                        }
                        break;
                    }

                    arr[r][col + 1] = arr[r][col];
                    arr[r][col] = 0;
                    col++;
                }
            }
        }
        return max;
    }

    static int moveLeft(int arr[][]) {
        int max = 0;
        for (int r = 0; r < N; r++) {
            int lastMerge = -1;
            for (int c = 1; c < N; c++) {
                int col = c;
                while (col >= 1) {
                    if (arr[r][col - 1] != 0) {
                        if ((lastMerge != col - 1) && (arr[r][col - 1] == arr[r][col])) {
                            arr[r][col - 1] <<= 1;
                            arr[r][col] = 0;
                            lastMerge = col - 1;
                            max = Math.max(max, arr[r][col - 1]);
                        }
                        break;
                    }

                    arr[r][col - 1] = arr[r][col];
                    arr[r][col] = 0;
                    col--;
                }
            }
        }
        return max;
    }

    static int moveUp(int arr[][]) {
        int max = 0;
        for (int c = 0; c < N; c++) {
            int lastMerge = -1;
            for (int r = 1; r < N; r++) {
                int row = r;
                while (row >= 1) {
                    if (arr[row - 1][c] != 0) {
                        if ((lastMerge != row - 1) && (arr[row - 1][c] == arr[row][c])) {
                            arr[row - 1][c] <<= 1;
                            arr[row][c] = 0;
                            lastMerge = row - 1;
                            max = Math.max(max, arr[row - 1][c]);
                        }
                        break;
                    }

                    arr[row - 1][c] = arr[row][c];
                    arr[row][c] = 0;
                    row--;
                }
            }
        }
        return max;
    }

    static int moveDown(int arr[][]) {
        int max = 0;
        for (int c = 0; c < N; c++) {
            int lastMerge = -1;
            for (int r = N - 2; r >= 0; r--) {
                int row = r;
                while (row <= N - 2) {
                    if (arr[row + 1][c] != 0) {
                        if ((lastMerge != row + 1) && (arr[row + 1][c] == arr[row][c])) {
                            arr[row + 1][c] <<= 1;
                            arr[row][c] = 0;
                            lastMerge = row + 1;
                            max = Math.max(max, arr[row + 1][c]);
                        }
                        break;
                    }

                    arr[row + 1][c] = arr[row][c];
                    arr[row][c] = 0;
                    row++;
                }
            }
        }
        return max;
    }
}