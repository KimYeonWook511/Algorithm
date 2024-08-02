import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        String Month = input[0];
        int DD = (input[1].charAt(0) - '0') * 10 + (input[1].charAt(1) - '0');
        int YYYY = Integer.parseInt(input[2]);
        int MM = (input[3].charAt(3) - '0') * 10 + (input[3].charAt(4) - '0');
        MM += ((input[3].charAt(0) - '0') * 10 + (input[3].charAt(1) - '0')) * 60;

        int month = 0;
        if (Month.equals("January")) month = 1;
        else if (Month.equals("February")) month = 2;
        else if (Month.equals("March")) month = 3;
        else if (Month.equals("April")) month = 4;
        else if (Month.equals("May")) month = 5;
        else if (Month.equals("June")) month = 6;
        else if (Month.equals("July")) month = 7;
        else if (Month.equals("August")) month = 8;
        else if (Month.equals("September")) month = 9;
        else if (Month.equals("October")) month = 10;
        else if (Month.equals("November")) month = 11;
        else if (Month.equals("December")) month = 12;

        boolean chk = false;
        if (YYYY % 400 == 0 || (YYYY % 4 == 0 && YYYY % 100 != 0)) chk = true;

        int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int i = 1; i < month; i++) {
			if (chk && i == 2) {
				DD += 29;
				continue;
			}

			DD += days[i];
		}

        MM += (DD - 1) * 24 * 60;

        System.out.println((double)(MM * 100) / (chk ? 366 * 24 * 60 : 365 * 24 * 60));

        br.close();
    }
}