package IterativeRecursive;
import java.util.*;
class Node{
   Node left,right;
   int data;
    
   Node(int data){
      this.data=data;
      this.left=null;
      this.right=null;
   }
}

public class BinaryTree{
   Node root;
   int non_leaf=0;
   int leaf=0;
   int h1=0,h2=0;
   
   public void insert(int key){
      if(root== null){
         root=new Node(key);
         return;
      }
      Node temp=root;
      while(true){
        Node parent=temp;
        if(key>temp.data){
          temp=temp.right;
          if(temp==null){
            parent.right=new Node(key);
            return;
          }
        }
        else{
           temp=temp.left;
           if(temp==null){
             parent.left=new Node(key);
             return;
           } 
        }
      }
   }
   
   public void levelOrderIterative(Node node){
      if(root==null){
        return;
      }
      Queue<Node> q=new LinkedList<>();
      q.add(node);
      while(!q.isEmpty()){
        Node curr=q.peek();
        q.remove();
           
        System.out.print(curr.data+" ");
        if(curr.left!=null){
          q.add(curr.left);
          h1++;
        } 
        if(curr.right!=null){
          q.add(curr.right);
          h2++;
        }
        if(curr.left==null && curr.right==null){
          leaf++;
        }
        else{
          non_leaf++;
        }
      } 
   }
   
   public void preOrderRecur(Node node){
      if(node==null){
        return;
      }
      System.out.print(node.data+" ");
      preOrderRecur(node.left);
      preOrderRecur(node.right);
   }
   
   public void inOrderRecur(Node node){
        if(node==null){
           return;
        }
        inOrderRecur(node.left);
        System.out.print(node.data+" ");
        inOrderRecur(node.right);
   } 
   
   public void postOrderRecur(Node node){
      if(node==null){
        return;
      }
      postOrderRecur(node.left);
      postOrderRecur(node.right);
      System.out.print(node.data+" ");
   }
   
   public static void main(String[] args) {
      BinaryTree tree=new BinaryTree();
      tree.insert(50);
      tree.insert(30);
      tree.insert(20);
      tree.insert(40);
      tree.insert(70);
      tree.insert(60);
      tree.insert(80);
      tree.insert(10);
      tree.insert(90);
      tree.insert(100);
      tree.insert(5);
      tree.insert(200);
      tree.insert(300);
      tree.preOrderRecur(tree.root);
      System.out.println();
      tree.levelOrderIterative(tree.root);
      System.out.println();
      tree.inOrderRecur(tree.root);
      System.out.println();
      tree.postOrderRecur(tree.root);
      System.out.println();
      System.out.println("Number of non-leaf nodes: "+tree.non_leaf);
      System.out.println("Number of leaf nodes: "+tree.leaf);
      System.out.println("Height of a tree is: "+Math.max(tree.h1,tree.h2));
    }
}
