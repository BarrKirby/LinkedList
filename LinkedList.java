import io.netty.util.internal.StringUtil;

public class linkedList<E extends Comparable<E>>{
    // instance variables of the SinglyLinkedList
    private Node<E> head = null;               // head node of the list (or null if empty)
    private Node<E> tail = null;               // last node of the list (or null if empty)

    public linkedList() {  // constructs an initially empty list

    }

    public int size() {//Returns the number of elements in the linked list.

        int size = 0;
        for(Node n = head; n.getNext() != null; n = n.getNext()) {
            size++;
        }

        return size;
    }

    public boolean isEmpty() { // Tests whether the linked list is empty.

        if(size()==0){
            return true;
        } else {
            return false;
        }

    }

    public E first() {  // returns (but does not remove) the first element

        if (head == null) {
            return null;
        } else {
            return head.getItem();
        }

    }

    public E last() {// returns (but does not remove) the last element

        if(tail == null) {
            return null;
        } else {
            return tail.getItem();

        }
    }

    public void addFirst(E e) {                // adds element e to the front of the list

        Node newNode = new Node(e,head);
        head = newNode;

        if(head.getNext() == null){
            tail = head;
        }

    }

    public void addLast(E e) {                 // adds element e to the end of the list

        if(head == null){
            addFirst(e);
        } else {

            Node newNode = new Node(e);
            tail.setNext(newNode);
            tail = newNode;

        }

    }

    public E removeFirst() {
        E firstElement =null;// removes and returns the first element

        if(head != null){
            return null;
        }
        return firstElement;

    }

    public E removeLast() {// removes and returns the first element

        E last = null;

        if(head == null){
            last = null;
        } else if(head.getNext() == null){
            last = head.getItem();
        } else {
            Node<E> curr = head;

            while(curr.getNext().getNext() != null) {
                curr = curr.getNext();
            }

            last = curr.getNext().getItem();
            curr.setNext(null);
            this.tail = curr;
        }

        return last;

    }

    public void concatenateList (linkedList<E> M) {//attach another linkedList refered by M to the end of this linkedList

        if(this.head == null){
            head = M.head;
            tail = M.tail;
        } else {
            tail.setNext(M.head);
            tail = M.tail;
        }

    }

    public int searchElement (E targetElement){//test if a target element can be found on the list, return the occurrences of the target element

        Node curr = head;
        int count = 0;

        while (curr != null){
            if(curr.getItem() == targetElement){
                count++;
            }
            curr = curr.getNext();
        }

        return count;
    }

    public void removeElement(E targetElement){//remove all target element that can be found on the list

        Node<E> curr = head;
        Node<E> prev = null;

        if(curr != null && curr.getItem() == targetElement){
            head = curr.getNext();
        }

        while (curr != null){

            if(curr.getItem() == targetElement){
                curr = curr.getNext();
            }
            curr = curr.getNext();
        }
    }

    public E middleElement(){//find and return the element that stored at the middle node of a linkedList

        Node <E> slowPointer = head;
        Node <E> fastPointer = head;

        if(head != null){
            while(fastPointer != null && fastPointer.getNext() != null){
                fastPointer = fastPointer.getNext().getNext();
                slowPointer = slowPointer.getNext();
            }

            return slowPointer.getItem();

        }


        return null;

    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getItem());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }
}
