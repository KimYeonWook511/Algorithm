import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int[] a = new int[testcase];
		int[] b = new int[testcase];
		
		for (int i = 0; i < testcase; i++)
		{
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		for (int i = 0; i < testcase; i++)
		{
			System.out.println("Case #" + (i + 1) + ": " + a[i] + " + " + b[i] + " = " + (a[i] + b[i]));
		}
		
		sc.close();
	}
}