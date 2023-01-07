import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] seq = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			seq[i] = sc.nextInt();
			
			if (seq[i] < x)
			{
				 System.out.print(seq[i] + " ");
			}
		}
		
		sc.close();
	}
}