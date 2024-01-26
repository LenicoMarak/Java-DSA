package MyLinkedStack;

public class LinkedListStack<T>{
  Node<T> top;
  private static class Node<T>{    
     T data;    
     Node<T> next;    
     public Node(T data){    
         this.data = data;    
         this.next = null;    
     }
  }
  public boolean isEmpty(){ 
     return top==null; 
  }
 
  public void push(T x){
    Node<T> temp=new Node(x);
    temp.data=x;
    temp.next=top;
    top=temp;
  }
  
  public T peek(){
    return top.data;
  }
  
  public T pop(){
      if(top == null) {
         System.out.print("\nStack Underflow");
         return -1;
      }
      T d=top.data;
      top=top.next;
      return d;
  } 
  
  public static void reverse(LinkedListStack<T> s){
      LinkedListStack<T> temp1=new LinkedListStack<>();
      LinkedListStack<T> temp2=new LinkedListStack<>();
      while(!s.isEmpty() && !temp1.isEmpty()){
         T x=s.peek();
         s.pop();
         temp1.push(x);
         if(s.isEmpty()){
           temp2.push(temp1.pop());
         }
      }
  }
  
  public void display(){
    Node<T> curr=top;
    if(isEmpty()){
      System.out.print("Stack is empty");
    }
    System.out.print("[ ");
    while(curr!=null){
      System.out.print(curr.data+" ");
      curr=curr.next;
    }
    System.out.println("]");
  }
  
  public static void main(String[] args){
    LinkedListStack<Integer> s=new LinkedListStack<>();
    s.push(20);
    s.push(30);
    s.push(40);
    s.push(50);
    s.push(60);
    s.display();
    reverse(s);
    System.out.print("After pop-up:- ");
    s.display();
  }
}   
