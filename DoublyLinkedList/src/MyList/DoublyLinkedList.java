package MyList;
import java.util.*;
class DLLNode<E> {
    private DLLNode<E> next,prev;
    private E data;
    DLLNode(E data){
        this.data=data;
        this.next=prev=null;
    }
    public E getData(){
        return data;
    }
    public DLLNode<E> getNext(){
        return next;
    }
    public DLLNode<E> getPrev(){
        return prev;
    }
    public void setNext(DLLNode<E> next){
        this.next=next;
    }
    public void setPrev(DLLNode<E> prev){
        this.prev=prev;
    }
}  
public class DoublyLinkedList<E>{
  DLLNode<E> head,tail;
  public int getLength(){
     int len=0;
     DLLNode<E> curr=head;
     while(curr!=null){
          curr=curr.getNext();
          len++;
     }
     return len;
  }
  public void insertFront(E item){ 
      DLLNode<E> newNode=new DLLNode<E>(item); 
      if(head==null)
         tail=newNode; 
      else
         head.setPrev(newNode); 
         newNode.setNext(head);
         head = newNode;
    }
    public void insertBefore(E curData,E x){
        DLLNode<E> newNode=new DLLNode<E>(x);
        DLLNode<E> curr=head;
        while(curr!=null){
            if(curr==head) {
                 newNode.setPrev(null);
                 newNode.setNext(head);
                 head.setPrev(newNode);
                 head=newNode;
                  return;
              }
              else if(curr.getData()==curData){            
                   newNode.setPrev(curr.getPrev());
                   newNode.setNext(curr);
                   curr.getPrev().setNext(newNode);
                   curr.setPrev(newNode);
                   break;
             }
             else{
                  curr=curr.getNext();
             }
        }
   }
   public void insertAfter(E afterVal, E item) {
     DLLNode<E> n = new DLLNode<E>(item);
     DLLNode<E> curr = head;
     
      if(head == null) {
         head = n;
      }
      else {
         while(curr != null && curr.getData()!=afterVal) {
            curr = curr.getNext();
         }
         if(curr != null) {
            n.setNext(curr.getNext());
            n.setPrev(curr);
            n.getNext().setPrev(n);
            curr.setNext(n);
         }
         else {
             System.out.println("The Key "+afterVal+" doesn't exist: ");
         }
       }
    }
    public void insertAtLast(E x){
        DLLNode<E> newNode=new DLLNode<E>(x);
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail=newNode;
    }
    public void delete(E x) {
        if(head.getData()==x) {
            head=head.getNext();
            head.setPrev(null);
            return;
        }
        DLLNode<E> temp=head;
        while(temp.getData()!=x) {
            temp=temp.getNext();
        }
        if(temp.getNext()!=null) {
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            temp.setPrev(null);
            temp.setNext(null);
            return;
        }
        else {
            temp.getPrev().setNext(null);
            tail=temp.getPrev();
            temp.setNext(null);
            System.out.println("Deleted :"+x);
        }
    }
    public void deleteFront() {  
        if(head == null) {  
           throw new NoSuchElementException();
        }  
        else {  
            if(head != tail) {  
                head = head.getNext();
            }  
            else {  
                head = tail = null;  
            }  
        }  
    }
    public void deleteAtLast() {  
       DLLNode<E> temp = tail;
       if (head == null) 
           throw new NoSuchElementException();
        if (head==tail) { 
            head.setNext(null);
        } 
        else {
          tail.getPrev().setNext(null); 
        }
        tail=tail.getPrev();
        temp.setPrev(null);
    }
    public int search(E val){
       DLLNode<E> curr=head;
       int listCount=1;
       while(curr!=null){
         if(curr.getData()==val){
            System.out.println("Searching:- "+val);
            return listCount; 
         }
         else{
           curr=curr.getNext();
           listCount++;
         }
       }
     return -1;
    }
    public void reversePrint(){ 
       DLLNode<E> temp =tail;
       System.out.print("null~");
       while(temp!=null){ 
        System.out.print(temp.getData()+"~"); 
        temp = temp.getPrev(); 
       }
      System.out.println("<-----Reversed list.");
    } 
    public void printList() { 
        DLLNode<E> node=head;
        System.out.print("null~");
        while (node!= null) { 
            System.out.print(node.getData() + "~"); 
            node = node.getNext(); 
        } 
       System.out.println("null");
    }
    public static void main(String[] args) {
      DoublyLinkedList<Integer> list=new DoublyLinkedList<>();
      System.out.println("*Doubly Linked List*");
      list.insertFront(10);
      list.insertFront(20);
      list.insertFront(40);      
      //30 will be insert before 40
      list.insertBefore(40,30);
      list.insertAtLast(60);
      //50 will be insert after the 20
      list.insertAfter(20,50);
      list.printList();
      //reverse by traversing from the last node
      list.reversePrint();
      int target=list.search(50);
      System.out.println("Items found at position:- "+target);
      list.deleteFront();
      System.out.print("After deleting front item:- ");
      list.printList();
      list.delete(10);
      System.out.print("After deleting 10:- ");
      list.printList();
      list.deleteAtLast();  
      System.out.print("After deleting last item:- ");
      list.printList(); 
          
       
    }
}

