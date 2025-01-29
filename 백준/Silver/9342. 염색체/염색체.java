import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
		String regex = "[A-F]?A+F+C+[A-F]?$";
		
        for (int t = 0; t < T; t++) {
            sb.append(br.readLine().matches(regex) ? "Infected!" : "Good").append("\n");
        }

		System.out.print(sb);

        br.close();
    }
}