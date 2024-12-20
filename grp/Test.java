import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    
    public static void main(String[] args) {
        System.out.println("APPWORKS");

        HashMap <Integer,Integer[]> g = new HashMap<Integer,Integer[]>();

        g.put(1, new Integer[] {2,3});
        g.put(2, new Integer[] {});
        g.put(3, new Integer[] {4,5});
        g.put(4, new Integer[] {6});
        g.put(5, new Integer[] {});
        g.put(6, new Integer[] {5});

        

        //Test.BrathFirst(g, 4);
        Test.DepthFirst(g, 3);
        System.out.println(" ");
        System.out.println(Test.Haspath(g, 3, 1));


    }


    public static void BrathFirst(HashMap<Integer,Integer[]> grp , Integer start){

        Queue<Integer> queue = new LinkedList<Integer>();

        //print checker
        HashMap<Integer, Boolean> printChecker = new HashMap<Integer,Boolean>();

        for (Integer integer : grp.keySet()) {
            printChecker.put(integer, false);
            
        }

        //add start to queue
        queue.add(start);

        while (!queue.isEmpty()) {
    
            //get queue value
            Integer toPrint = queue.poll();

            if(printChecker.get(toPrint) == false){
                System.out.print( toPrint + " " );

                // set print details
                printChecker.put(toPrint, true);
            }

            //add toPrint pointer values to queue
            for (Integer values : grp.get(toPrint)) {
                queue.add(values);
            }

        }
    }


    public static void DepthFirst(HashMap<Integer,Integer[]> grp , Integer start){

        Stack<Integer> stack = new Stack<Integer>();

         //print checker
         HashMap<Integer, Boolean> printChecker = new HashMap<Integer,Boolean>();

         for (Integer integer : grp.keySet()) {
             printChecker.put(integer, false);
             
         }

        //add first
        stack.push(start);

        while (!stack.isEmpty()) {

            Integer current = stack.pop();
            if(printChecker.get(current) == false){
                System.out.print( current + " " );
                printChecker.put(current, true);
            }
            
            //add to stack
            for (Integer integer : grp.get(current)) {
                stack.add(integer);
            }
        }
    }


    public static boolean Haspath(HashMap<Integer,Integer[]> grp , Integer start,Integer end){

        Stack<Integer> stack = new Stack<Integer>();

        //print checker
        HashMap<Integer, Boolean> printChecker = new HashMap<Integer,Boolean>();

        for (Integer integer : grp.keySet()) {
            printChecker.put(integer, false);
            
        }

       //add first
       stack.push(start);

       while (!stack.isEmpty()) {

           Integer current = stack.pop();
           if(printChecker.get(current) == false){
               
                if(current == end){
                    return true;
                }
               printChecker.put(current, true);
           }
           
           //add to stack
           for (Integer integer : grp.get(current)) {
               stack.add(integer);
           }
       }

       return false;
    }
}
