package DemoFact;
import java.util.*;
 class Main {
    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
        int fact=1;
        System.out.print("Enter a number:");
        int num=input.nextInt();
        for(int i=1;i<=num;i++){
            fact*=i;
        }
        System.out.println("The Factorial of "+num+" is: "+fact);
        input.close();
    }
    
}
