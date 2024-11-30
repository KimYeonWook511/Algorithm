import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int G = Integer.parseInt(br.readLine());
		
		long s = 1;
		long e = 2;
		boolean flag = false;

		while (e < 100_000) {
			long ss = s * s;
			long ee = e * e;

            if (ee - ss > G) {
                s++;
            } else {
                if(ee - ss == G) {
                    sb.append(e).append("\n");
                    flag = true;
                }

                e++;
            }
		}
		
        System.out.println(flag ? sb : -1);

        br.close();
    }
}