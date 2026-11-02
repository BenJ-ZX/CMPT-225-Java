class LinkedList<T>{

    class LinkedListNode {
        T val;
        LinkedListNode next;

        LinkedListNode(T val, LinkedListNode next){
            this.val = val;
            this.next = next;

        }


    }

    private LinkedListNode Head;
    private LinkedListNode Tail;

    public void addToHead(T element){
        this.Head = new LinkedListNode(element, this.Head);
    }

    public T removeFromHead(){

        T ret = this.Head.val;

        this.Head = this.Head.next;

        return ret;

    }

}


public class DataStructures {

}
