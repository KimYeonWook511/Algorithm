import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean chk[][] = new boolean[6][6];
        boolean flag = true;

        String input = br.readLine();
        int col = input.charAt(0) - 'A';
        int row = input.charAt(1) - '1';
        chk[col][row] = true;

        int start[] = {col, row};
        int temp[] = {col, row};

        for (int i = 1; i < 35; i++) {
            input = br.readLine();
            col = input.charAt(0) - 'A';
            row = input.charAt(1) - '1';

            if (!func(col, row, temp, chk)) flag = false;

            chk[col][row] = true;
        }

        input = br.readLine();
        col = input.charAt(0) - 'A';
        row = input.charAt(1) - '1';

        if (!func(col, row, start, chk)) flag = false;

        System.out.println(flag ? "Valid" : "Invalid");

        br.close();
    }

    static boolean func(int col, int row, int temp[], boolean chk[][]) {
        if (chk[col][row]) return false;

        int c = Math.abs(col - temp[0]);
        int r = Math.abs(row - temp[1]);
        temp[0] = col;
        temp[1] = row;

        if (r == 2 && c == 1) return true;
        if (r == 1 && c == 2) return true;

        return false;
    }
}