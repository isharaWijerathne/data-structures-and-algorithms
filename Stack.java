

class Stack {
    public int top;
    private int[] arr;

    public Stack(int length) {
        this.arr = new int[length];
        this.top = -1;
    }

    public void  push(int data){
        if(top == -1){
            arr[0] = data;
            top = 0;
        }else {
            top++;
            arr[top] = data;
        }
    }

    public void Print(){
       for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
       }
    }

    public int  Peek(){
        return arr[top];
    }

    public boolean IsEmpty(){
        return top == -1;
    }

    public int pop(){
        if(top == -1){
            return 0;
        }
        else {
            int temp = arr[top];
            arr[top] = 0;
            top--;
            return temp;
        }

     
        
    }

}