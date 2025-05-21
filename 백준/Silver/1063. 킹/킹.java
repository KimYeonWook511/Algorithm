import java.io.*;
import java.util.*;

public class Main {

    static char[] king, stone;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = st.nextToken().toCharArray();
        stone = st.nextToken().toCharArray();
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            char[] nextKing = move(command, king);

            if (isInRange(nextKing)) { // 킹이 체스판 안에 있으면
                if (nextKing[0] == stone[0] && nextKing[1] == stone[1]) { // 킹이 돌과 겹치면
                    char[] nextStone = move(command, stone);

                    if (isInRange(nextStone)) { // 돌이 체스판 안에 있으면
                        king = nextKing;
                        stone = nextStone;
                    }
                } else {
                    king = nextKing;
                }
            }
        }

        System.out.println(king[0] + "" + king[1]);
        System.out.println(stone[0] + "" + stone[1]);
    }

    static boolean isInRange(char[] a) {
        if (a[0]<'A' || a[0]>'H' || a[1]<'1' || a[1]>'8') return false;
        else return true;
    }

    static char[] move(String command, char[] target) {
        char[] result = target.clone();
        if (command.equals("R")) {
            result[0]++;
        } else if (command.equals("L")) {
            result[0]--;
        } else if (command.equals("B")) {
            result[1]--;
        } else if (command.equals("T")) {
            result[1]++;
        } else if (command.equals("RT")) {
            result[0]++; result[1]++;
        } else if (command.equals("LT")) {
            result[0]--; result[1]++;
        } else if (command.equals("RB")) {
            result[0]++; result[1]--;
        } else if (command.equals("LB")) {
            result[0]--; result[1]--;
        }
        return result;
    }
}