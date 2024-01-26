

class CSNode<T>{
     private CSNode<T> next;
     private T data;
     CSNode(T data){
         this.data=data;
         this.next=null;
     }
     public T getData(){
         return data;
     }
     public CSNode<T> getNext(){
         return next;
     }
     public void setNext(CSNode<T> next){
         this.next=next;
     }
}
class CircularList<T>{
    CSNode<T> head,tail;
    CircularList(){
       this.head=null;
       this.tail=null;
    }
 
    public int size() {
        int size=0;
        if (head!=null) {
           CSNode<T> temp=head;
           while(temp.getNext()!=head){
               temp=temp.getNext();
               size++;
          }
         size++;
        }
       return size;
    }
    public void insertAtFront(T item) {
        CSNode<T> newNode=new CSNode<T>(item);
        if (head==null) {
            head=newNode;
            tail=newNode;
            newNode.setNext(head);
        }
        else{
            CSNode<T> temp=head;
            newNode.setNext(temp);
            head=newNode;
            tail.setNext(head);
        }
    } 
    
    public void insertAtLast(T data) {
        CSNode<T> newNode=new CSNode<T>(data);
        if(head==null) {
           head=newNode;
           tail=newNode;
           newNode.setNext(head);
        }
        else{
            tail.setNext(newNode);
            tail=newNode;
            tail.setNext(head);
        }
    }
    public void delete(T d) {
        if(head==null)
        System.out.println("List is empty");
        CSNode<T> currNode=head;
        CSNode<T> newNode=new CSNode<T>(d);
        while(currNode.getData()!=d) {
           if(currNode.getNext()==head) {
              System.out.println("Given node with data " +d+ " is not exist!.");
              break;
            }
            newNode=currNode;
            currNode=currNode.getNext();
        }
        if(currNode==head && currNode.getNext()==head) {
           head=null;
         }
         if(currNode==head) {
            newNode=head;
            while(newNode.getNext()!=head) {
                 newNode=newNode.getNext();
           }
           head=currNode.getNext();
           newNode.setNext(head);
         }
         else if(currNode.getNext()==head) {
                 newNode.setNext(head);
         }
         else{
             newNode.setNext(currNode.getNext());
         }
        System.out.println("Deleting:- "+d);
    }
    public void deleteFront() {
        if(head==null) {
           return;
         } 
         else if(head!=tail) {
               head=head.getNext();
               tail.setNext(head);
         }
         else{
             head=tail=null;
         }
    }
    public void deleteLast() {
        if(head==null){
           return;
        }
        else if(head!=tail){
             CSNode<T> current=head;
             while(current.getNext()!=tail){
                  current=current.getNext();
             }
             tail=current;
             tail.setNext(head);
        }
        else{
            head=tail=null;
        }
    }
    public int search(T val){
        CSNode<T> temp=head;
        int count=1;
        if(head==null){
            return -1;
        }
        do{
           if(temp.getData()==val){
              System.out.println("Searching:- "+val);
              break;
           }
           else{
               temp=temp.getNext();
               count++;
           }
       }
       while(temp!=head);
       return count;
    }
    /*public void reverse(){
        CSNode<T> curr=head;
        CSNode<T> forward;
        CSNode<T> prev=null;
        while(curr!=head){
            forward=curr.next;
            forward.next=prev;
            prev=curr;
            curr=forward;
        }
        head.next=prev;
        head=prev;
}*/
    
    public void display() {
        CSNode<T> temp=head;
        if(head==null){
            System.out.println("The list is empty!");
        }
        else{
            System.out.print("[ ");
            do{                
                System.out.print(temp.getData()+" ");
                temp = temp.getNext();
            }
            while(temp!=head);
        }
         System.out.println("]");
    }
    public void reverse(CSNode<T> current) {  
        //Checks if the next node is head, if yes then prints it.  
        if(current.getNext()==head){  
           System.out.print(current.getData()+" "); 
           return;  
        }  
         //Recursively calls the reverse function  
        reverse(current.getNext());  
        System.out.print(current.getData()+" ");
    }
           
    public boolean isCircular(){
        CSNode<T> temp=head.getNext();
        if(temp==null){
            return false;
        }
        while(temp!=null && temp!=head){
            temp=temp.getNext();
        }
        return (temp==head);           
    }
    public static void main(String[] args){
        CircularList<Integer> list=new CircularList<>();
        System.out.println("*Circular Singly Linked List*");
        list.insertAtLast(40);
        list.insertAtLast(30);       
        list.insertAtLast(10);
        list.insertAtFront(20);
        list.display();
        System.out.print("After reversing:- ");
        list.reverse(list.head);
        System.out.println();
      //System.out.println("Is list in circular:- "+list.isCircular());
       int find=list.search(40);
        System.out.println("Elements found at position:- "+find);
        list.deleteLast();
        System.out.print("After deleting last node:-");
        list.display();
        list.delete(30);
        System.out.print("After deleted:-");
        list.display();
        list.deleteFront();
        System.out.print("After deleting front item:-");
        list.display();
      /*  list.insertAtFront(5);
        System.out.print("After inserting at front:- ");
        list.display();*/
    }
    
}
