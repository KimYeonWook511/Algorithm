import java.io.*;

public class Main {
    static String S;
    static char result[];
    static int cnt[] = new int[3];
    static boolean visited[][][][][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        result = new char[S.length()];

        for (int i = 0; i < S.length(); i++) {
            cnt[S.charAt(i) - 'A']++;
        }
        visited = new boolean[cnt[0] + 1][cnt[1] + 1][cnt[2] + 1][2][3];

        boolean noResult = dfs(0, 0, 0);
        if (noResult) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

        br.close();
    }

    static boolean dfs(int idx, int checkB, int checkC) {
        if (idx == S.length()) return false;
        if (visited[cnt[0]][cnt[1]][cnt[2]][checkB][checkC]) return true;

        if (cnt[2] > 0 && checkC <= 0) {
            cnt[2]--;
            result[idx] = 'C';
            if (!dfs(idx + 1, Math.max(checkB - 1, 0), 2)) return false;
            cnt[2]++;
        }

        if (cnt[1] > 0 && checkB <= 0) {
            cnt[1]--;
            result[idx] = 'B';
            if (!dfs(idx + 1, 1, Math.max(checkC - 1, 0))) return false;
            cnt[1]++;
        }

        if (cnt[0] > 0) {
            cnt[0]--;
            result[idx] = 'A';
            if (!dfs(idx + 1, Math.max(checkB - 1, 0), Math.max(checkC - 1, 0))) return false;
            cnt[0]++;
        }

        return visited[cnt[0]][cnt[1]][cnt[2]][checkB][checkC] = true;
    }
}