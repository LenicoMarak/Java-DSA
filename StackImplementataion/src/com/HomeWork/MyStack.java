package com.HomeWork;

class MyStack<T>{
      T[] elements;
      int top;
      static final int max_size=10;
  public MyStack(){
       top=-1;
       elements=(T[]) new Object[ max_size];
    } 
   public boolean isStackEmpty(){
       return top==-1;
    }
   public boolean isFull(){
       return top==max_size-1;
    }
   public void push(T item) throws Exception{
       if(isFull()){     
         System.out.println("Stack Overflow");
         System.exit(1);
       }
         elements[++top]=item;
    }
   public T pop(){
       if(isStackEmpty()){
         System.out.println("Satck Underflow!!");
       }
         T entry=elements[top--];    
         return entry;   
    }
   public void display(){  
      System.out.print("[ ");
         for(int i=0;i<=top;i++){
           
            System.out.print(elements[i]+" ");
        }
        System.out.println("]");
    }  
   public static void main(String[] args) {
      try{
         MyStack<String> stack1=new MyStack<String>();
         MyStack<Integer> stack2=new MyStack<Integer>();
         MyStack<Character> stack3=new MyStack<Character>();
         stack1.push("C++");
         stack1.push("Python");
         stack1.push("Java");
         stack1.display();
         stack1.pop();
         System.out.print("After poped-up:- ");
         stack1.display();
         stack2.push(10);  
         stack2.push(20);
         stack2.push(30);
         stack2.display();
         stack2.pop();
         System.out.print("After poped-up:- ");
         stack2.display();
         stack3.push('A');
         stack3.push('B');
         stack3.push('C');
         stack3.display();
         stack3.pop();
         System.out.print("After poped-up:- ");
         stack3.display(); 
      }catch(Exception e){
        e.printStackTrace();
      } 
   }    
}

