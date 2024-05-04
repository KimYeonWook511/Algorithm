import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Integer> menu = new HashMap<>();
        HashMap<String, String> kindOfMenu = new HashMap<>();

        int generalMenuNum = Integer.parseInt(st.nextToken());
        int specialMenuNum = Integer.parseInt(st.nextToken());
        int serviceMenuNum = Integer.parseInt(st.nextToken());

        for(int i=0; i<generalMenuNum; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            menu.put(name, Integer.parseInt(st.nextToken()));
            kindOfMenu.put(name, "general");
        }

        for(int i=0; i<specialMenuNum; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            menu.put(name, Integer.parseInt(st.nextToken()));
            kindOfMenu.put(name, "special");
        }


        for(int i=0; i<serviceMenuNum; i++) {
            String name = br.readLine();
            menu.put(name, 0);
            kindOfMenu.put(name, "service");
        }

        long generalPrice = 0;
        long specialPrice = 0;
        int specialSize = 0;
        int orderServiceMenuNum = 0;

        int orderMenuNum = Integer.parseInt(br.readLine());

        for(int i=0; i<orderMenuNum; i++){
            String orderMenu = br.readLine();
            String menuKind = kindOfMenu.get(orderMenu);

            if(menuKind.equals("general"))
                generalPrice += menu.get(orderMenu);
            else if(menuKind.equals("special")){
                specialPrice += menu.get(orderMenu);
                specialSize++;
            }
            else orderServiceMenuNum ++;

        }

        if((generalPrice < 20000 && specialSize > 0) || (generalPrice + specialPrice < 50000 && orderServiceMenuNum > 0) || orderServiceMenuNum > 1)
            System.out.println("No");
        else
            System.out.println("Okay");

    }

}