package Read;
import java.util.*;

public class Main {
    public int getNum(char x){
        switch(x){
            case'I':
                return 1;
            case'V':
                return 5;
            case'X':
                return 10;
            case'L':
                return 50;
            case'C':
                return 100;
            case'D':
                return 500;
            case'M':
                return 1000;
            default:
                return 0;               
        }
    }
    public  int convert(String a){
        int total=0;
        for(int i=0;i<a.length();i++){
            int s1=getNum(a.charAt(i));         
            if(i+1<a.length()){ 
               int s2=getNum(a.charAt(i+1));
               if(s1>=s2){
                 total+=s1;
               }
               else{
                   total=total+s2-s1;
                   i++;
               }
            }
            else{
                total+=s1;
            }
        }
        return total;      
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Main obj=new Main();
        System.out.print("Enter a Roman symbol: " );
        String b=scan.nextLine();
        String up=b.toUpperCase();
        int result=obj.convert(up);
        System.out.println("Roman converted to: "+result); 
        scan.close();
    }    
}
