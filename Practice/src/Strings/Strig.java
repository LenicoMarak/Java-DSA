package Strings;
import java.util.*;

public class Strig {
    public void reverseVowel(){
        
    }
    public void reversePrint(String s){
        int len=s.length()-1;
        for(int i=len;i>=0;i--){
            System.out.print(s.charAt(i));
        }
        System.out.println();
    }
    public void display(String x){
        for(int i=0;i<=x.length();i++){
            System.out.print(x.charAt(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Strig obj=new Strig();
        System.out.println("Enter a string");
        String in=scan.nextLine();
        obj.display(in);
        obj.reversePrint(in);
        scan.close();
        
        
    }
    
}

