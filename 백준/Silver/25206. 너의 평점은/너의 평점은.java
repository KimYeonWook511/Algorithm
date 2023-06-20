import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		double total = 0;
		double totalScore = 0;
		
		for (int run = 0; run < 20; run++) {
			st = new StringTokenizer(br.readLine());
			
			st.nextToken();
			
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			if (!grade.equals("P")) {
				totalScore += score;
				
				if (grade.equals("A+")) {
					total += score * 4.5;
				
				} else if (grade.equals("A0")) {
					total += score * 4.0;
					
				} else if (grade.equals("B+")) {
					total += score * 3.5;
					
				} else if (grade.equals("B0")) {
					total += score * 3.0;
					
				} else if (grade.equals("C+")) {
					total += score * 2.5;
					
				} else if (grade.equals("C0")) {
					total += score * 2.0;
					
				} else if (grade.equals("D+")) {
					total += score * 1.5;
					
				} else if (grade.equals("D0")) {
					total += score * 1.0;
				}
			}
		}
		
		System.out.printf("%.6f", total / totalScore);
		
		br.close();
	}
}