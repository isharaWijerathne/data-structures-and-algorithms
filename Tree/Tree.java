package Tree;

import java.util.Stack;

public class Tree <T> {
    public TreeNode <T> root;


    public void PreOrderR(TreeNode <T> root){
        
        //base base case
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        PreOrderR(root.left);
        PreOrderR(root.right);
    }


    public void PreOrderI(TreeNode <T> root){

        Stack< TreeNode <T> > stack  = new Stack< TreeNode <T> >();
        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode <T> temp = stack.pop();
            System.out.print( temp.data + " " );

            if(temp.right != null){
                stack.push(temp.right);
            }

            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }


    public void InOrderR(TreeNode <T> root){

        //base base case
        if(root == null){
            return;
        }
        InOrderR(root.left);
        System.out.print(root.data + " ");
        InOrderR(root.right);
    }

    public void InOrderI(TreeNode <T> root){

        
        Stack< TreeNode <T> > stack  = new Stack< TreeNode <T> >();
        
        TreeNode <T> temp = root;
        
        while ( !stack.isEmpty()  || temp != null) {
            
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }

    }


    public void PostOrderR(TreeNode <T> root){
            
          //base base case
          if(root == null){
            return;
        }
        PostOrderR(root.left);
        PostOrderR(root.right);
        System.out.print(root.data + " ");

    }


    public void PostOrderI(TreeNode <T> root){

        
        Stack< TreeNode <T> > stack  = new Stack< TreeNode <T> >();
        
        TreeNode <T> current = root;

        while(current !=null ||  !stack.isEmpty()){

            if(current != null){
                stack.push(current);
                current = current.left;
            }else {
                
                TreeNode <T> temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop(); // neeed tooo useee pol
                    System.out.print( temp.data + " ");

                    //write side of parent
                    while (!stack.isEmpty()  &&  temp == stack.peek().right) {
                        temp =stack.pop();

                        System.out.print(temp.data + " ");
                    }
                }else{
                    current = temp;
                }

            }
        }
        
        

    }



}
