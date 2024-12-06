


 class s {

    public s next;
    public int data;

    public s(int data) {
       this.data = data;
    }
    
}
 class LinkList {

    public s head;

    public void AddNumber(int data){

       s newNode = new s(data);

       if(this.head == null){
        this.head = newNode;
        return;
       }

       s current = this.head;

       while (current.next != null) {
            current = current.next;
       }
       current.next = newNode;
    }
    
    public void AddNumber(int data,int position){

        s newNode = new s(data);

      
        if(position == 1){
            s temp = this.head;
            this.head = newNode;
            newNode.next = temp;
        }
        else{
            int count = 1;
            s previous = this.head;
            while (count < position - 1) {
           
                previous = previous.next;
                count++;
            }

            s temp = previous.next;
            newNode.next = temp;
            previous.next = newNode;

          
        }
    }

    public void Print(){

        s temp = this.head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");

        
    }

    public void Print(s root){

        s temp = root;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");

    }

    public void DeleteFirstNode(){
        this.head = this.head.next;
    }

    public void DeleteLastNode(){
        s current = this.head;
        s previous = null;
        
        while (current.next != null) {
            previous = current;
            current = current.next;
            
        }

        previous.next = null;
        //System.out.println(temp.data);
    }

    public void DeleteNode(int position){

        if(position == 1){
            s temp = this.head;
            this.head = temp.next;
        }else {
           
            s previous = this.head;
           
            int count = 1;

            while (count < position - 1) {
               previous = previous.next;
                count++;
            }

            s temp = previous.next;
            previous.next = temp.next;


        }
    }

    public int GetListNodeCount(){
        s temp = this.head;

        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    public void ReversLinkList(){
        int arrayLength = GetListNodeCount();

        int keyValue[] = new int[arrayLength];

        s temp = this.head;

        int count = 0;
        while (temp != null) {
            keyValue[count] = temp.data;
            temp = temp.next;
            count++;
        }

        int temPos = 1;
       for (int i = 0; i < keyValue.length; i++) {

            AddNumber(keyValue[keyValue.length - i - 1], temPos);
            DeleteLastNode();
            temPos++;
       }
    }

    public void ReversLinkListPro(){
       s current = this.head;
       s pre = null;
       s next = null;
       
       while (current != null) {
        next = current.next;
        current.next = pre;

        pre = current;
        current = next;
       }

       Print(pre);
    }

    public void RemoveDublicatesFromLinkList(){
    
        s current = this.head;
        s next = current.next;
        s pre = null;
        while (current.next!=null) {
        
            if(current.data == next.data ){
              
                pre.next = current.next;
               current = next;
               next = current.next;
            }else{
                pre = current;
                current = current.next;
                next = current.next;
            }
        }

        
        
    }

    public void InsertDataToSortedLinkList(int data){

        s current = this.head;
        s next = current.next;
        

        s newNode = new s(data);

        while (next != null) {
            


            if((current.data <= data ) &&  ( data < next.data)){

                current.next = newNode;
                newNode.next = next;

                current = newNode.next;
                next = current.next;

            }else {
                current = current.next;
                next = current.next;
            }
        }

        if(current.data < newNode.data){
            current.next = newNode;
        }

    }

    public void DeleteKey(int data){

        s current = this.head;
        s pre = null;
        s next = current.next;

        while (next !=null) {
            
            if(current.data == data){

                pre.next = current.next;
                current = current.next;
                next = current.next;

            }else{
                pre = current;
                current = current.next;
                next = current.next;
            }
        }
    }

    public void FindLoop(s head){

        s slowP = head;
        s fastP = head.next;

        while (slowP != null) {

            System.out.println("work");
            if(slowP == fastP){

                System.out.println("Loop found" + slowP.data + " " + fastP.data);
                break;
            }
            
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
    }

    public void FindLoopStartingPoint(s head){

        s slowP = head;
        s fastP = head;

        while (fastP != null && fastP.next != null) {
            
            fastP = fastP.next.next;
            slowP = slowP.next;

            if(slowP == fastP){

                //
                s temp = head;
                s slow = slowP;
                s pre = null;
                while (slow != temp) {
                    pre = slow;
                    slow = slow.next;
                    temp = temp.next;
                }
                
                System.out.println("Loop Start At " + slow.data);
                pre.next = null;
                break;
            }
        }
    }

    public s LinkListFormSorted(s first,s second){

        s dummy = new s(0);
        s tail = dummy;

        s l1 = first;
        s l2 = second;

        while (l1 !=null && l2 != null) {
            
            if(l1.data < l2.data){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
          tail = tail.next;

        }

        if(l1 == null){
            tail.next = l2;
        }
        else {
            tail.next = l1;
        }
        return dummy.next;
    }


    public s AddLinkList(s a, s b){
        s dummy = new s(0);

        s tail = dummy;
        int carry = 0;
        while(a != null || b!= null){

            int A = a != null ? a.data : 0;
            int B = b != null ? b.data : 0;

            int sum = carry +  A + B;

            int ans_to_node = sum % 10;
            carry = sum / 10;
            tail.next = new s(ans_to_node);

            tail =tail.next;
            if(a != null) a = a.next;
            if(b!= null) b=b.next;
        }

        if(carry >0){
            tail.next = new s(carry);
        }
        return dummy.next;
    }

}


