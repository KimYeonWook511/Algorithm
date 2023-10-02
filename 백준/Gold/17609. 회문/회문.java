import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int run = 0; run < t; run++) {
            String str = br.readLine();
            int result = 0;

            int leftIdx = 0;
            int rightIdx = str.length() - 1;

            while (leftIdx < rightIdx) {
                if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                    String leftDel = str.substring(leftIdx + 1, rightIdx + 1);
                    String rightDel = str.substring(leftIdx, rightIdx);

                    if (leftDel.substring(0, (leftDel.length() + 1) / 2).equals(
                        new StringBuilder(leftDel.substring(leftDel.length() / 2)).reverse().toString())) result = 1;
                    else if (rightDel.substring(0, (rightDel.length() + 1) / 2).equals(
                        new StringBuilder(rightDel.substring(rightDel.length() / 2)).reverse().toString())) result = 1;
                    else result = 2;

                    break;
                }

                leftIdx++;
                rightIdx--;
            }

            sb.append(result).append("\n");
        }   

        System.out.println(sb.toString());

        br.close();
    }
}