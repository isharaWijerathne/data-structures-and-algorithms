import java.util.NoSuchElementException;



class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}


class CircularSinglyLinkedList {

    public Node last;
    public int length;

    public void InsertFirst(int data){

        Node newNode = new Node(data);

        if(IsEmpty()){
            this.last = newNode;
            newNode.next = last;
            length++;
        }else{
            Node oldfirst = this.last.next;

            this.last.next = newNode;
            newNode.next = oldfirst;

            length++;
        }


    }


    public boolean IsEmpty(){
        return this.length == 0;
    }


    public void Print(){
        
        Node first = this.last.next;

        while (first != last) {
            System.out.print(first.data + " -> ");
            first = first.next;
        }
        System.out.print(first.data + " -> ");

    }

    public void DeleteFirst(){
        if(IsEmpty()){
            throw new NoSuchElementException();
        }

        if(length == 1){
            this.last = null;
            length--;
        }else{
            Node firstOld = this.last.next;
            Node newFirst = firstOld.next;

            this.last.next = newFirst;
            firstOld.next = null;
            
            length--;
        }


    }



}