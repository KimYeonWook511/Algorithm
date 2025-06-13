import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());
		
		double left = 0;
		double right = Math.min(x, y);
		double xPow2 = Math.pow(x, 2);
		double yPow2 = Math.pow(y, 2);
		while (right - left >= 0.001) {
			double mid = (left + right) / 2;
			double midPow2 = Math.pow(mid, 2);
			
			double xHeight = Math.sqrt(xPow2 - midPow2);
            double yHeight = Math.sqrt(yPow2 - midPow2);
            double val = (xHeight * yHeight) / (xHeight + yHeight);
  
            if (val < c) right = mid;
            else left = mid;
		}
		
		System.out.println(String.format("%.3f", right));
		
		br.close();
	}
}