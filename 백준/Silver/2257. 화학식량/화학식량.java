import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('H', 1);
        map.put('C', 12);
        map.put('O', 16);

        int result = 0;
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);

            if (c == '(') deque.offerLast(-1);
            else if (c >= 'A' && c <= 'Z') deque.offerLast(map.get(c));
            else if (c != ')') deque.offerLast(deque.pollLast() * (c - '0'));
            else {
                int sum = 0;
                int temp = 0;

                while (temp != -1) {
                    temp = deque.pollLast();

                    if (temp == -1) break;
                    
                    sum += temp;
                }
                
                deque.offerLast(sum);
            }
        }

        while (!deque.isEmpty()) {
            result += deque.pollLast();
        }

        System.out.println(result);
    }
}