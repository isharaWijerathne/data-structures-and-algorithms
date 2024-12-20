import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Undirected {
    public static void main(String[] args) {


        HashMap <Integer,Integer[]> g = new HashMap<Integer,Integer[]>();

        g.put(1, new Integer[] {2});
        g.put(2, new Integer[] {1});
        g.put(3, new Integer[] {});
        g.put(4, new Integer[] {6});
        g.put(5, new Integer[] {6});
        g.put(6, new Integer[] {4,5,7,8});
        g.put(7, new Integer[] {6});
        g.put(8, new Integer[] {6});

       Undirected.FindLagestComponet(g);
    }

    public static void DepthFirst(HashMap <Integer,Integer[]> grp , Integer start){

        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            if( !visited.contains(current)){
                 System.out.print(current + " ");
                 visited.add(current);

                 for (Integer integer : grp.get(current)) {
                   
                    if( ! visited.contains(integer)){
                        stack.add(integer);
                    }
                }
            }

            
        }

    }

    public static Boolean HasPath(HashMap <Integer,Integer[]> grp , Integer start,Integer target){

        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            if( !visited.contains(current)){
                 
                if(current == target){
                    return true;
                }

                 visited.add(current);

                 for (Integer integer : grp.get(current)) {
                   
                    if( ! visited.contains(integer)){
                        stack.add(integer);
                    }
                }
            }

            
        }
        return false;
    }

    public static Integer ConnectedComponetcount(HashMap <Integer,Integer[]> grp ){

        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        ArrayList<Integer> nodeList = new ArrayList<Integer>();

        for (int node : grp.keySet()) {
            nodeList.add(node);
        }

        ArrayList<Integer> fullVisited = new ArrayList<Integer>();
        
        Integer count = 0;
        for (Integer node : nodeList) {

            
            if(!fullVisited.contains(node)){
                count ++;
            }

            Integer start = node;
            stack.push(start);
    
            while (! stack.isEmpty()) {
                
                Integer currnt = stack.pop();
                if(!visited.contains(currnt)){
                    //System.out.print(currnt+" ");
                    visited.add(currnt);

                    if(!fullVisited.contains(currnt)){
                        fullVisited.add(currnt);
                    }
    
                    for (Integer integer : grp.get(currnt)) {
                        
                        if(! visited.contains(integer)){
                            stack.add(integer);
                        }
                    }
                }
            }

        }

       
     return count;

    }

    public static void FindLagestComponet(HashMap <Integer,Integer[]> grp){

        ArrayList<Integer> visited = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        
        ArrayList<Integer> pre = new ArrayList<Integer>();
        ArrayList<Integer> next = new ArrayList<Integer>();
        
        HashMap <Integer,Object[]> components = new HashMap<Integer,Object[]>();


        for (Integer node : grp.keySet()) {
            nodeList.add(node);
        }


        for (Integer node : nodeList) {
            
            Integer start = node;
            stack.push(start);
    



            while (!stack.isEmpty()) {

                Integer current = stack.pop();
                if ( ! visited.contains(current)) {
                   // System.out.print( current + " ");
                    visited.add(current);
                    next.add(current);
                    
                }
    
                for (Integer integer : grp.get(current)) {
                   
                    if(!visited.contains(integer)){
                        stack.add(integer);
                    }
                    
                }
            }


            if(next.equals(pre)){

                next.clear();
            }else{
               pre.equals(next);
                
               //store next

               components.put(next.size(), next.toArray());
                next.clear();
            }
            
    
        }

       
        for (Integer integer : components.keySet()) {

            System.out.print("[" + integer + "]");

            for (Object integer2 : components.get(integer)) {
                
                System.out.print( integer2 + " ");
            }
            System.out.println(" ");
        }

    }

    

    
}
