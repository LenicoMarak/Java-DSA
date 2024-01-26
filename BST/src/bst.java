class Queue{
  BSTNode arr[];
  int front,rear,count;
   Queue(){
     arr=new BSTNode[30];
     front=rear=-1;
     count=0;
   }
   public void enqueue(BSTNode x){
     if(count<30){
       rear=(rear+1)%30;
       arr[rear]=x;
       count++;
       if(front==-1) 
       front=0;
     }
   }
   public BSTNode dequeue(){
     BSTNode t=arr[front];
     front=(front+1)%30;
     count--;
     return t;
   }
   public boolean isEmpty(){
     return count==0;
   }
}

class Stack{
   BSTNode arr[]=new BSTNode[20];
   int top;
   Stack(){
     top=-1;
   }
   public boolean isEmpty(){ 
     return top==-1;
   }
   public void push(BSTNode x){
     arr[++top]=x;
   }
   public BSTNode pop(){
     return arr[top--];
   }
}

class BSTNode{
   int data;
   BSTNode left,right;
   BSTNode(int d){
     data=d;
     left=right=null;
   } 
}

class BSTree{
   BSTNode root;
   BSTree(int d){
    root=new BSTNode(d);
   }
   public int insert(int d){
     BSTNode loc,par;
     loc=root;
     par=null;
     while(loc!=null && loc.data!=d){
       par=loc;
       if(loc.data>d)
         loc=loc.left;
       else 
         loc=loc.right; 
     }
     if(loc!=null) 
       return 0;
     if(loc==null &&par==null){
       root=new BSTNode(d);
       return 1;
     }
     else{
       BSTNode t=new BSTNode(d);
       if(par.data>d)
         par.left=t;
       else 
         par.right=t;
         return 1; 
     }
   }
   public void levelOrder(){
     Queue q=new Queue();
     BSTNode t;
     q.enqueue(root);
     while(!q.isEmpty()){
       t=q.dequeue();
       System.out.print(" "+t.data);
       if(t.left!=null)
         q.enqueue(t.left);
       if(t.right!=null)
         q.enqueue(t.right);
     }
   }
   public void inorder(){
     inorderrecur(root);
   }
   public void inorderrecur(BSTNode r){
     if(r==null)
      return;
     inorderrecur(r.left);
     System.out.print(" "+r.data);
     inorderrecur(r.right);
   }
   public void preorder(){
     preorderrecur(root);
   }
   public void preorderrecur(BSTNode r){
     if(r==null)
      return;
     System.out.print(" "+r.data);
     preorderrecur(r.left);
     preorderrecur(r.right);
   }
   public void inorderNonRecur(){
     Stack stack=new Stack();
     BSTNode curr=root,t;
     while(true){
       for(;curr!=null;curr=curr.left)
         stack.push(curr);
         while(curr==null && !stack.isEmpty()){
           t=stack.pop();
           System.out.print(" "+t.data);
           curr=t.right;
         }
         if(curr==null && stack.isEmpty())
          break;
     } 
   }
   public void preorderNonRecur(){
     Stack s=new Stack();
     BSTNode t;
     s.push(root);
     while(!s.isEmpty()){
       t=s.pop();
       System.out.print(" "+t.data);
       if(t.right!=null) 
         s.push(t.right);
       if(t.left!=null)
         s.push(t.left);
     }
   }
}

public class bst{
  public static void main(String args[]){
    BSTree bsTree= new BSTree(7);
    bsTree.insert(2);
    bsTrer.insert(5);
    bsTree.insert(9);
    bsTrer.insert(6);
    bsTree.insert(3);
    bsTree.insert(8);
    bsTree.insert(4);
    bsTree.levelOrder();
  }
}
