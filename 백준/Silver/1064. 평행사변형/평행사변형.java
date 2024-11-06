import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int ax = Integer.parseInt(st.nextToken());
		int ay = Integer.parseInt(st.nextToken());
		int bx = Integer.parseInt(st.nextToken());
		int by = Integer.parseInt(st.nextToken());
		int cx = Integer.parseInt(st.nextToken());
		int cy = Integer.parseInt(st.nextToken());

		double result = -1;

		if ((bx - ax) * (cy - ay) != (cx - ax) * (by - ay)) {
			double ab = Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
			double ac = Math.sqrt(Math.pow(ax - cx, 2) + Math.pow(ay - cy, 2));
			double bc = Math.sqrt(Math.pow(bx - cx, 2) + Math.pow(by - cy, 2));

			result = (Math.max(ab, Math.max(ac, bc)) - Math.min(ab, Math.min(ac, bc))) * 2;
		}

		System.out.println(result);

		br.close();
	}
}