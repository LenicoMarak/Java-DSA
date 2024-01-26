package FactorialDemo;
import java.util.*;
public class Main {
    static int Factorial(int n){
        if(n<=1){
            return 1;
         }
        else{
            return n*Factorial(n-1);
         }  
     }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number: ");
         int num=input.nextInt();
             input.close();
         int result=Factorial(num);
        System.out.println("The factorial of "+num+" is: "+result);
            
    }
    
}
