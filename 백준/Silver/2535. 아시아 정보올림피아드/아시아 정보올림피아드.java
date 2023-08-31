import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Student {
		String country;
		String number;
		int record;
		
		public Student(String country, String number, String record) {
			this.country = country;
			this.number = number;
			this.record = Integer.parseInt(record);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Student arr[] = new Student[n];
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			arr[run] = new Student(st.nextToken(), st.nextToken(), st.nextToken());
		}

		Arrays.sort(arr, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.record - o1.record;
			}
		});
		
		int chk = 2;
		
		if (arr[0].country.equals(arr[1].country)) {
			while (arr[chk].country.equals(arr[0].country)) {
				chk++;
			}
		}
		
		sb.append(arr[0].country).append(" ").append(arr[0].number).append("\n");
		sb.append(arr[1].country).append(" ").append(arr[1].number).append("\n");
		sb.append(arr[chk].country).append(" ").append(arr[chk].number);
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
