import java.util.NoSuchElementException;

class DublyLinkedList {

    public Node head;
    public Node tail;
    public int length;
    
    public int Length(){
        return this.length;
    }

    public boolean isEmpty(){
        return this.length == 0;

    }

    public void InsertFromStart(int data){

        Node newNode = new Node(data);

        if(isEmpty()){
            this.tail = newNode;
            this.length ++;
        }else{
            this.head.pre = newNode;
            this.length ++;

        }
        newNode.next = head;
        head = newNode;

    }

    public void TravelStart(){
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;

        }
        System.out.println(" null ");
    }

    public void TravelEnd(){
        Node temp = this.tail;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.pre;

        }
        System.out.println(" null ");

    }

    public void InsertFromEnd(int data){
        Node newNode = new Node(data);

        Node temp = tail;
        if(isEmpty()){
            this.head = newNode;
            this.length++;
        }else{
           this.tail.next = newNode;
           newNode.pre = tail;
            this.length++;
        }

        tail = newNode;
       
    }

    public void DeleteFirstNode(){

        if(isEmpty()){
            throw new  NoSuchElementException();
        }
        if(tail == head){
            head = null;
            tail = null;
            length--;
        }else{
            if(this.head != null){
                this.head = this.head.next;
                this.head.pre = null;
                length--;
            }
        }
    }

    public void DeleteLastNode(){

        if(isEmpty()){ throw new NoSuchElementException();}

        Node temp  = tail;
        if(head == tail){
            head = null;
            tail = null;
            length--;
        }else{
            if(tail != null){
                tail = tail.pre;
                tail.next = null;
                temp.pre = null;
                length--;
            }
        }


    }


}

class Node {
       
    public int data;
    public Node pre;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}


