import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class App {

    public static void main(String[] args) {
        

        //graph
       HashMap<String,String[]> g = new HashMap<String,String[]>();

       g.put("a",new String[] {"b","c"});
       g.put("b",new String[] {"d"});
       g.put("c",new String[] {"e"});
       g.put("d",new String[] { "f"});
       g.put("e",new String[] {});
       g.put("f",new String[] {});
      
     App.Brathfirst(g);


    }

    public static void Brathfirst(
        HashMap<String,String[]> graph    
    ){

       HashMap <String,Boolean> isPrinted = new HashMap<String,Boolean>();

       for (String key : graph.keySet()) {
        isPrinted.put(key, false);
       }

       Queue<String> q = new LinkedList<String>();
      
       String first = isPrinted.keySet().iterator().next();
       q.add(first);
       while (!q.isEmpty()) {
            
            String currnt = q.poll();
           
            if( isPrinted.get(currnt) == false){
                System.out.print(currnt + " ");
                isPrinted.put(currnt,true);
            }

            String[] item = graph.get(currnt);
            for (int i = 0; i < item.length; i++) {
                q.add(item[i]);
            }

            if(item.length == 0 ){

            }
           
       }


    }
}

