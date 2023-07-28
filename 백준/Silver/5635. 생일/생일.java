import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Student {
		String name;
		int dd;
		int mm;
		int yyyy;
		
		Student(String name, int dd, int mm, int yyyy) {
			this.name = name;
			this.dd = dd;
			this.mm = mm;
			this.yyyy = yyyy;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> list = new ArrayList<>(); 
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.yyyy != o2.yyyy) return o2.yyyy - o1.yyyy;
				else if (o1.mm != o2.mm) return o2.mm - o1.mm;
				else return o2.dd - o1.dd;
			}
		});
		
		System.out.println(list.get(0).name + "\n" + list.get(n - 1).name);
		
		br.close();
	}
}
