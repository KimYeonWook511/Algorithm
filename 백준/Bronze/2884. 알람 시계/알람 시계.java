import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		
		if (m >= 45)
		{
			System.out.println(h + " " + (m - 45));
		}
		else
		{
			if (h == 0)
			{
				System.out.println(23 + " " + (m + 15));
			}
			else
			{
				System.out.println((h - 1) + " " + (m + 15));
			}
		}
		
		sc.close();
	}
}