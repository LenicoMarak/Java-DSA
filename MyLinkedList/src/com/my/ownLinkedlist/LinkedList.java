package com.my.ownLinkedlist;
public class LinkedList<T>{
        
  private static class Node<T>{    
      private  T data;    
      private Node<T> next;    
            
      public Node(T data) {    
         this.data = data;    
         this.next = null;    
      }
      public T getData(){
         return data;
      }  
      public Node<T> getNext(){
         return next;
      }
  }
  
  public Node<T> head = null;    
  public Node<T> tail=null; 
  public void insert(T data) {     
      Node<T> newNode = new Node<T>(data);    
      if(head == null) {      
         head = newNode;    
         tail = newNode;    
      }    
      else{      
          tail.next = newNode;    
          tail = newNode;    
      }    
  } 
  
  public void display(){      
      Node<T> current = head;    
      if(head == null) {    
        System.out.println("List is empty");    
         return;    
      } 
      // System.out.print(" [");
      while(current != null) {       
          System.out.print("["+current.data+"] ");
          current = current.next;
      }    
      System.out.println();    
  }  
  
  public void delete(T value){
      Node<T> temp = head;
      Node<T> previous = null;

      if(temp == null){
        System.out.println("Can't delete Linked List empty");
        return;
      }
      if(temp.next==null) {
         head = null;
         System.out.println("Deleted: " + value);
         return;
      }
      if(temp.data==value) {
         head = temp.next;
         System.out.println("Deleted: " + value);
         return;
      }
      while(temp !=null && temp.data != value){
          previous = temp;
          temp = temp.next;
      }
      if(temp==null){
         System.out.println("Value not found");
         return;
      }
      previous.next = temp.next;
      System.out.println("Deleted: " + value);
  }
  
  public int search(T element){
      System.out.println("Searching: "+element);
      if(head == null) {
         return -1;
      }
      int index = 0;
      Node<T> temp = head;
      while(temp != null){
         if(temp.data == element){
            return index;
         }
         index++;
         temp = temp.next;
      }
      return -1;
  }
  
  public void reverse() {
      Node<T> curr = head;
      Node<T> pre = null; 
      Node<T> incoming = null;
      while(curr != null) {
          incoming = curr.next;
          curr.next = pre;   
          pre = curr;             
          curr = incoming;   
      }
      head = pre; 
  }
  
  public void concat(LinkedList<T> linkedList) {
      if(linkedList.head == null) {
          return;
      } 
      else{
         Node<T> curr = linkedList.head;
         while(curr != null) {
             insert(curr.getData());
             curr = curr.getNext();
         }
      }
  }
  
  public static void main(String[] args) {  
      LinkedList<Integer> list1=new LinkedList<>(); 
      LinkedList<Integer> list2=new LinkedList<>(); 
      System.out.print("List 1:");
      list1.insert(10);
      list1.insert(20);
      list1.insert(30);
      list1.insert(40);
      list1.display();
      int target1=list1.search(40);
      System.out.println("Element found at node number: "+target1);
      list1.reverse();
      System.out.print("After reversing a list:");
      list1.display();
      list1.delete(30);
      System.out.print("After deleting:");
      list1.display();
      System.out.print("List 2:");
      list2.insert(50);
      list2.insert(60);
      list2.insert(70);
      list2.insert(80);
      list2.display();
      LinkedList<Integer> con=new LinkedList<>();
      System.out.print("After concatenating:");
      con.concat(list1);
      con.concat(list2);
      con.display();
  }   
}    