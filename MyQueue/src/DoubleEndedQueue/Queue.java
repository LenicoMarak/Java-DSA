

// Circular Queue implementation in Java

public class Queue<T>{
  final int size= 5; // Size of Circular Queue
  int front, rear;
  T[] items;

  Queue() {
    items=(T[]) new Object[size];
    front = -1;
    rear = -1;
  }

  // Check if the queue is full
  boolean isFull() {
    if (front == 0 && rear == size - 1) {
      return true;
    }
    if (front == rear + 1) {
      return true;
    }
    return false;
  }

  // Check if the queue is empty
  boolean isEmpty() {
    if (front == -1)
      return true;
    else
      return false;
  }

  // Adding an element
  void enQueue(T element){
    if (isFull()) {
       System.out.println("Queue is full.");
    } else {
      if (front == -1)
        front = 0;
      rear = (rear + 1) % size;
      items[rear] = element;
     System.out.println("Inserting: " + element);
    }
  }

  // Removing an element
  void deQueue() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return;
    } else {
      if (front == rear) {
        front = -1;
        rear = -1;
      }
      else {
        front = (front + 1) % size;
        System.out.println("Removing:- "+front);
      }
    }
  }

  void display() { 
    int i;
    if (isEmpty()) {
      System.out.println("Empty Queue");
    } 
    else {
      System.out.print("[");
      for (i = front; i!=rear;i= (i + 1) % size)
        System.out.print(items[i] + ",");
        System.out.print(items[i]);
      }
    System.out.println("]");
   }
}  
class Run{
  public static void main(String[] args) {

    Queue<Integer> q = new Queue<>();

    q.enQueue(1);
    q.enQueue(2);
    q.enQueue(3);
    q.enQueue(4);
    q.enQueue(5);
    System.out.print("Circular Queue:- ");
    q.display();
    q.deQueue();
    System.out.print("After removing front item:- ");
    q.display();
    q.enQueue(6);
    System.out.print("After adding item:- ");
    q.display();
  }

}
