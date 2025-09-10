import java.io.*;
import java.util.*;

public class Main {
    static double val[][][] = new double[4][4][3];
    static double results[] = new double[4];
    static final int INDEX_COMBINATION[][] = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String teams[] = new String[4];
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            String name = st.nextToken();
            teams[i] = name;
            indexMap.put(name, i);
        }

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            double W = Double.parseDouble(st.nextToken());
            double D = Double.parseDouble(st.nextToken());
            double L = Double.parseDouble(st.nextToken());

            int indexA = indexMap.get(A);
            int indexB = indexMap.get(B);

            val[indexA][indexB][0] = W;
            val[indexA][indexB][1] = D;
            val[indexA][indexB][2] = L;

            val[indexB][indexA][0] = L;
            val[indexB][indexA][1] = D;
            val[indexB][indexA][2] = W;
        }

        // 3^6
        func(0, 1.0, new int[4]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            sb.append(results[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void func(int idx, double rate, int sum[]) {
        if (idx == 6) {
            int sortSum[][] = new int[5][2];
            for (int i = 0; i < sum.length; i++) {
                sortSum[i][0] = i;
                sortSum[i][1] = sum[i];
            }
            sortSum[4][1] = -1;

            Arrays.sort(sortSum, new Comparator<int[]>() {
                @Override
                public int compare(int o1[], int o2[]) {
                    return -Integer.compare(o1[1], o2[1]);
                }
            });

            int remainCount = 2;; // 남은 수
            int temp[] = new int[4]; // 동률팀 index 스택
            int tempIndex = 0;
            for (int r = 0; r < 4; r++) { 
                temp[tempIndex++] = sortSum[r][0];

                if (sortSum[r][1] == sortSum[r + 1][1]) {
                    continue;
                }

                double share = Math.min(1.0, (double)remainCount / tempIndex);
                for (int i = 0; i < tempIndex; i++) {
                    int index = temp[i];
                    results[index] += share * rate;
                }

                remainCount -= tempIndex;
                tempIndex = 0;

                if (remainCount <= 0) break;
            }

            return;
        }

        int indexA = INDEX_COMBINATION[idx][0];
        int indexB = INDEX_COMBINATION[idx][1];

        // 승
        if (val[indexA][indexB][0] != 0) {
            sum[indexA] += 3;
            func(idx + 1, rate * val[indexA][indexB][0], sum);
            sum[indexA] -= 3;
        }

        // 무
        if (val[indexA][indexB][1] != 0) {
            sum[indexA] += 1;
            sum[indexB] += 1;
            func(idx + 1, rate * val[indexA][indexB][1], sum);
            sum[indexA] -= 1;
            sum[indexB] -= 1;
        }

        // 패
        if (val[indexA][indexB][2] != 0) {
            sum[indexB] += 3;
            func(idx + 1, rate * val[indexA][indexB][2], sum);
            sum[indexB] -= 3;
        }
    }
}