package trail;

public class Polynomial {
   Node headNode,lastNode;   
   class Node{
        int coffi,degree;
        Node next;
        Node (int d1,int d2){
            coffi=d1;
            degree=d2;
            next=null;
        }
   }
   public void append(int co,int ex){
      if(headNode==null){
         headNode=new Node(co,ex);
         lastNode=headNode;
         return;
      }
      lastNode.next=new Node(co,ex);
      lastNode=lastNode.next;
   }
   public static Polynomial addPoly(Polynomial po1,Polynomial po2){
      Polynomial result=new Polynomial();
      Node temp1=po1.headNode;
      Node temp2=po2.headNode;
      while(temp1!=null && temp2!=null){
         if(temp1.degree==temp2.degree){
              int x=temp1.coffi+temp2.coffi;
              result.append(x,temp1.degree);
              temp1=temp1.next;
              temp2=temp2.next;
         }
         else if(temp1.degree>temp2.degree){
            result.append(temp1.coffi,temp1.degree);
            temp1=temp1.next;
         }
         else if(temp1.degree<temp2.degree){
             result.append(temp2.coffi,temp2.degree);
             temp2=temp2.next;
         }
         if(temp1==null){
            result.append(temp2.coffi,temp2.degree); 
            temp2=temp2.next;
         }
         else if(temp2==null){
            result.append(temp1.next.coffi,temp1.next.degree);
            temp1=temp1.next;           
         }
      }
      return result;
   }
   public String toString(){
        String s = "";
        Node temp = headNode;
        if (temp == null){
            s = "null";
        }
        else {
            while (temp != null){
                if (temp.coffi== 1){
                    s += "x^" + temp.degree;
                    temp = temp.next;
                } 
                else { 
                    s += temp.coffi+ "x^" + temp.degree;
                    temp = temp.next;
                }
                if (temp != null){
                    s += " + ";
                }
            }
        }
        return s + "\n" ;
   }
   public static void main(String[] args) {
        Polynomial poly1=new Polynomial();
        poly1.append(5,3);
        poly1.append(4,2);
        poly1.append(2,1);
        Polynomial poly2=new Polynomial();
        poly2.append(6,3);
        poly2.append(3,1);
        poly2.append(7,0);
        System.out.print(poly1);
        System.out.print(poly2);
        System.out.println(addPoly(poly1,poly2));
   }
    
}

