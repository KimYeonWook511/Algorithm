import java.io.*;

public class Main {
    static final char NUMBERS[] = {'1', '2', '3'};
    static char answer[];
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        answer = new char[N];

        func(0);

        br.close();
    }

    static void func(int cur) {
        if (flag) return;

        if (cur == answer.length) {
            System.out.println(answer);
            flag = true;
            return;
        }

		for (char number : NUMBERS) {
			answer[cur] = number;
			if (check(cur)) {
				func(cur + 1);
			}
		}
    }

    static boolean check(int cur) {
        int len = (cur + 1);
        int half = len / 2;
        for (int size = 1; size <= half; size++) {
            boolean isSame = true;
            for (int i = 0; i < size; i++) {
                if (answer[cur - size - i] != answer[cur - i]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) return false;
        }
        return true;
    }
}