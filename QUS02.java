public class QUS02 {
    // public static void main(String[] args) {
    //     System.out.println("app work");
    //     StackS test = new StackS(5);
    //     System.out.println(test.StringValidator("{({{apple}})}"));

    // }
}

class StackS {
    char[] arr;
    int length;

    public StackS(int length) {
        arr = new char[length];
        this.length = -1;
    }

    public void push(char data){

        if(length == -1){
            arr[0] = data;
            length++;
        }else{
            length++;
            arr[length] = data;
        }
    }

    public boolean IsEmpty(){
        return this.length == -1;
    }

    public void pop(){
        if(this.length == 0){
            arr[0] = ' ';
            length = -1;

        }else{
            arr[length] = ' ';
            length--;
        }
    }

    public char peek(){

        if(this.length == -1){
            return ' ';
        }else{

          return arr[length];
        }
       
    }

    public boolean StringValidator(String str){

        char[] input_string = str.toCharArray();
        
        StackS stack = new StackS(input_string.length);

        for (int i = 0; i < input_string.length; i++) {
            
            //add
            if(input_string[i] == '(' || input_string[i] == '{' || input_string[i] == '['){
                stack.push(input_string[i]);
            }

            //removve order
            if(input_string[i] == ')' || input_string[i] == '}' || input_string[i] == '}')
            {

                if((stack.peek() == '(' && input_string[i] == ')') ||
                    (stack.peek() == '[' && input_string[i] == ']') ||
                    (stack.peek() == '{' && input_string[i] == '}' )
                ){
                     // remove item
                     stack.pop();;
                }else{
                    return false;
                }
            }
        }


        return stack.IsEmpty();
    }
}
