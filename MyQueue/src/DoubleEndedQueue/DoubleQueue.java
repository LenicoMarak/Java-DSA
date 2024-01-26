package DoubleEndedQueue;
 
class Node<T>{
     
    private Node<T> prev;
    private Node<T> next;
    private T value; 
    public Node<T> getPrev() {
        return prev;
    }
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}
public class DoubleQueue<T> {
 
    private Node<T> front;
    private Node<T> rear;
     
    public void insertFront(T item){
        //add element at the beginning of the queue
        System.out.println("Adding: "+item);
        Node<T> nd = new Node<T>();
        nd.setValue(item);
        nd.setNext(front);
        if(front != null) front.setPrev(nd);
        if(front == null) rear = nd;
        front = nd;
    }
     
    public void insertRear(T item){
        //add element at the end of the queue
        System.out.println("Adding: "+item);
        Node<T> nd = new Node<T>();
        nd.setValue(item);
        nd.setPrev(rear);
        if(rear != null) rear.setNext(nd);
        if(rear == null) front = nd;
         
        rear = nd;
    }
     
    public void removeFront(){
        if(front == null){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        //remove an item from the beginning of the queue
        Node<T> tmpFront = front.getNext();
        if(tmpFront != null) tmpFront.setPrev(null);
        if(tmpFront == null) rear = null;
        System.out.println("Removed from front: "+front.getValue());
        front = tmpFront;
    }
     
    public void removeRear(){
        if(rear == null){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        //remove an item from the beginning of the queue
        Node<T> tmpRear = rear.getPrev();
        if(tmpRear != null) tmpRear.setNext(null);
        if(tmpRear == null) front = null;
        System.out.println("Removed from rear: "+rear.getValue());
        rear = tmpRear;
    }
    public void display(){
        
        if (front==null && rear==null){
            System.out.print("Empty");
            return ;
        }
        Node<T> temp= front;
        System.out.print("[ ");
        while (temp!=rear.getNext() )
        {
            System.out.print(temp.getValue()+" ");
            temp=temp.getNext();
        }
        System.out.println("]");        
    }    
    public static void main(String a[]){
       DoubleQueue<Integer> deque = new DoubleQueue<Integer>();
        deque.insertFront(10);
        deque.insertFront(20);
        deque.insertFront(30);
        deque.display();
        deque.removeFront();
        System.out.print("After removing at front:- ");
        deque.display();
        deque.insertRear(43);
        System.out.print("After inserting at rear:- ");
        deque.display();
        deque.removeRear();
        System.out.print("After removing at rear:- ");
        deque.display();
    }
}
