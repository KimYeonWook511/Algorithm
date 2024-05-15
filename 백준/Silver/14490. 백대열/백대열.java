import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arr[] = br.readLine().split(":");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        int gcd = 0;

        if (num1 < num2) gcd = func(num2, num1);
        else gcd = func(num1, num2);
        
        System.out.println((num1 / gcd) + ":" + (num2 / gcd));

        br.close();
    }
    
    static int func(int a, int b) {
        a %= b;

        if (a == 0) return b;
        
        return func(b, a);
    }
}