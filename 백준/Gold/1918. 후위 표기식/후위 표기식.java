import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
   public static void main(String[] args) throws IOException {
      
      String str = br.readLine();
      Stack<String> operand = new Stack<>();
      Stack<Character> operator = new Stack<>();
      
      for (int i = 0; i < str.length(); i++) {
         char c = str.charAt(i);
         
         if (c >= 'A' && c <= 'Z') {
            operand.push(Character.toString(c));
            
         } else if (operator.empty()) {
            operator.push(c);
            
         } else if (c == '(') {
            operator.push(c);
            
         } else if (c == '+' || c == '-') {
            while (!operator.empty() && operator.peek() != '(') {
               String temp = operand.pop();
               operand.push(operand.pop() + temp + operator.pop());
            }
            
            operator.push(c);
            
         } else if (c == ')') {
            while (operator.peek() != '(') {
               String temp = operand.pop();
               operand.push(operand.pop() + temp + operator.pop());
            }
            
            operator.pop();
            
         } else {
            char top = operator.peek();
            
            if (top == '*' || top == '/') {
               String temp = operand.pop();
               operand.push(operand.pop() + temp + operator.pop());
            }
            
            operator.push(c);
         }
      }
      
      while (!operator.empty()) {
         String temp = operand.pop();
         operand.push(operand.pop() + temp + operator.pop());
      }

      System.out.println(operand.pop());
      
      br.close();
   }
}