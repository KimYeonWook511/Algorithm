import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<Long> notZeroSet = new HashSet<>();
        long val[][] = new long[10][2];
        for (int i = 0; i < 10; i++) {
            val[i][0] = i;
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            long weight = 1;

            for (int k = line.length() - 1; k >= 0; k--) {
                char ch = line.charAt(k);
                val[ch - 'A'][1] += weight;
                weight *= 10;
            }

            notZeroSet.add((long)(line.charAt(0) - 'A'));
        }
        
        Arrays.sort(val, new Comparator<long[]>() {
            @Override
            public int compare(long o1[], long o2[]) {
                return Long.compare(o1[1], o2[1]);
            }
        });
        
        long result = 0;
        int num = 1;
        boolean zeroFlag = false;
        for (int i = 0; i < 10; i++) {
            if (val[i][1] == 0) {
                if (zeroFlag) num++;

                zeroFlag = true;
                continue;
            }

            if (!zeroFlag && !notZeroSet.contains(val[i][0])) {
                zeroFlag = true;
                continue;
            }

            String strVal = Long.toString(val[i][1]);
            long weight = num;
            for (int k = strVal.length() - 1; k >= 0; k--) {
                result += (strVal.charAt(k) - '0') * weight;
                weight *= 10;
            }

            num++;
        }

        System.out.println(result);

        br.close();
    }
}